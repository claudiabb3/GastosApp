package com.clau.gastosapp.Controller;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;

import androidx.annotation.NonNull;
import com.clau.gastosapp.Model.MesModel;
import com.clau.gastosapp.activitys.Inicio;
import com.clau.gastosapp.activitys.Mescurso;
import com.clau.gastosapp.objetos.Gasto;
import com.clau.gastosapp.objetos.Mes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MesCursoController {

    private MesModel mesModel;
    private Mescurso view;
    private String mesId;
    private String mesNombre;
    private Double importe;

    public MesCursoController(Mescurso view) {
        this.view = view;
        this.mesModel = new MesModel();
    }

    public void loadMesEnCurso() {
        mesModel.getMesEnCurso(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Mes mes = snapshot.getValue(Mes.class);
                        if (mes != null) {
                            mesNombre = mes.getMes();
                            mesId = snapshot.getKey();
                            view.cargarMesEnCurso(mesNombre);
                            loadGastos(mesId);
                        }
                    }
                } else {
                    view.mensajeToast("No hay mes en curso");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                view.mensajeToast("Error al leer los datos");
            }
        });
    }

    public void loadGastos(String mesId) {
        mesModel.getGastos(mesId, new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<Gasto> listaGastos = new ArrayList<>();
                    Double totalGastos = 0.00;

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Gasto gasto = snapshot.getValue(Gasto.class);
                        if (gasto != null) {
                            gasto.setId(snapshot.getKey());
                            listaGastos.add(gasto);
                            totalGastos += gasto.getCantidad();
                        }
                    }
                    totalGastos = Math.round(totalGastos * 100.0) / 100.0;
                    importe = totalGastos;
                    view.cargarGastos(listaGastos, totalGastos);
                } else {
                    view.mensajeToast("No hay gastos");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                view.mensajeToast("Error al leer los gastos");
            }
        });
    }

    public void finalizarMes() {
        if (mesId == null || mesId.isEmpty()) {
            view.mensajeToast("No se ha encontrado el mes en curso.");
            return;
        }

        new AlertDialog.Builder(view)
                .setMessage("¿Estás seguro de que deseas finalizar el mes en curso?")
                .setPositiveButton("Sí", (dialog, which) -> {
                    mesModel.finalizarMes(mesId, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                            if (databaseError == null) {
                                view.mensajeToast("Mes finalizado");
                                loadGastos(mesId);
                                mostrarDialogoCompartir();
                            } else {
                                view.mensajeToast("Error al finalizar el mes");
                            }
                        }
                    });
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void compartirDatosPorWhatsApp() {
        if (importe == null) {
            view.mensajeToast("El importe no está disponible.");
            return;
        }

        String importeFormateado = String.format("%.2f", importe);
        String mensaje = "Los gastos de " + mesNombre + " son: " + importeFormateado;

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");

        try {

            view.startActivity(Intent.createChooser(sendIntent, "Compartir datos de gastos"));
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(view, Inicio.class);
                view.startActivity(intent);
                view.finish();
            }, 15000);

        } catch (android.content.ActivityNotFoundException ex) {
            view.mensajeToast("WhatsApp no está instalado en tu dispositivo.");
        }
    }

    private void mostrarDialogoCompartir() {
        new AlertDialog.Builder(view)
                .setMessage("¿Deseas compartir los datos de los gastos por WhatsApp?")
                .setPositiveButton("Sí", (dialog, which) -> compartirDatosPorWhatsApp())
                .setNegativeButton("No", null)
                .show();
    }

    public void eliminarGasto(String gastoId) {
        if (mesId == null || mesId.isEmpty()) {
            view.mensajeToast("No se ha encontrado el mes en curso.");
            return;
        }

        mesModel.eliminarGasto(mesId, gastoId, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    view.mensajeToast("Gasto eliminado");
                    loadMesEnCurso();
                } else {
                    view.mensajeToast("Error al eliminar el gasto");
                }
            }
        });
    }
}


