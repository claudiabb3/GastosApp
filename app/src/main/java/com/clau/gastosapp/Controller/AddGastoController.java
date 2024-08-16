package com.clau.gastosapp.Controller;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.clau.gastosapp.activitys.AddGasto;
import com.clau.gastosapp.objetos.Gasto;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Calendar;
public class AddGastoController {

    private final AddGasto view;

    public AddGastoController(AddGasto view) {
        this.view = view;
    }

    public void showDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(view, (view1, year, month, dayOfMonth) -> {
            String fechaSeleccionada = String.format("%02d/%02d/%d", dayOfMonth, month + 1, year);
            view.mostrarFecha(fechaSeleccionada);
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public void selectPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        view.startActivityForResult(intent, AddGasto.PICK_IMAGE_REQUEST);
    }

    public void onImageSelected(Uri uri) {
        view.mostrarImagen(uri);
    }

    public void saveGasto() {
        String descripcion = view.getDescripcionGasto();
        double importe = view.getImporteGasto();
        String fecha = view.getFechaGasto();
        Uri fotoUri = view.getFotoUri();

        if (descripcion.isEmpty() || fecha == null) {
            view.mostrarMensaje("Por favor, complete todos los campos obligatorios");
            return;
        }

        view.mostrarProgreso();

        if (fotoUri != null) {
            subirFotoYGuardarGasto(fotoUri, descripcion, importe, fecha);
        } else {
            guardarGastoEnBD(descripcion, importe, fecha, null);
        }
    }

    private void subirFotoYGuardarGasto(Uri fotoUri, String descripcion, double importe, String fecha) {
        StorageReference storageRef = FirebaseStorage.getInstance().getReference().child("gastos/" + fotoUri.getLastPathSegment());

        storageRef.putFile(fotoUri)
                .addOnSuccessListener(taskSnapshot -> storageRef.getDownloadUrl().addOnSuccessListener(uri -> {
                    String imagenUrl = uri.toString();
                    guardarGastoEnBD(descripcion, importe, fecha, imagenUrl);
                }))
                .addOnFailureListener(e -> {
                    view.ocultarProgreso();
                    view.mostrarMensaje("Error al subir la imagen");
                });
    }

    private void guardarGastoEnBD(String descripcion, double importe, String fecha, @Nullable String imagenUrl) {
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference("usuarios").child(userId).child("meses");

        databaseRef.orderByChild("estado").equalTo("enCurso").limitToLast(1)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                String mesId = snapshot.getKey();
                                DatabaseReference gastosRef = snapshot.child("gastos").getRef();

                                String gastoId = gastosRef.push().getKey();
                                if (gastoId != null) {
                                    Gasto gasto = new Gasto(descripcion, importe, fecha, imagenUrl);
                                    guardarGastoEnNodo(gastosRef, gastoId, gasto, snapshot.getRef(), importe);
                                }
                            }
                        } else {
                            view.mostrarMensaje("No hay mes en curso");
                            view.ocultarProgreso();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        view.mostrarMensaje("Error al leer los datos");
                        view.ocultarProgreso();
                    }
                });
    }

    private void guardarGastoEnNodo(DatabaseReference gastosRef, String gastoId, Gasto gasto, DatabaseReference mesRef, double importe) {
        gastosRef.child(gastoId).setValue(gasto)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        actualizarTotalGastos(mesRef, importe);
                    } else {
                        view.mostrarMensaje("Error al guardar el gasto");
                        view.ocultarProgreso();
                    }
                })
                .addOnFailureListener(e -> {
                    view.mostrarMensaje("Error al guardar el gasto");
                    view.ocultarProgreso();
                });
    }

    private void actualizarTotalGastos(DatabaseReference mesRef, double nuevoImporte) {
        mesRef.child("totalGastos").runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData currentData) {
                Double totalGastosActual = currentData.getValue(Double.class);
                if (totalGastosActual == null) {
                    totalGastosActual = 0.0;
                }
                totalGastosActual += nuevoImporte;
                currentData.setValue(totalGastosActual);
                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError databaseError, boolean committed, @Nullable DataSnapshot currentData) {
                if (databaseError == null && committed) {
                    view.mostrarMensaje("Nuevo gasto añadido");
                    view.ocultarProgreso();
                    view.finish();
                } else {
                    view.mostrarMensaje("Error al actualizar el total de gastos");
                    view.ocultarProgreso();
                }
            }
        });
    }

    public void handlePermissionsResult(int requestCode, @NonNull int[] grantResults) {
        if (requestCode == AddGasto.PERMISSION_REQUEST_CODE) {
            if (!(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
            }
        }
    }
}

