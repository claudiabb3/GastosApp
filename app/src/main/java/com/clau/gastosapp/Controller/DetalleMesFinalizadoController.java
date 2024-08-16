package com.clau.gastosapp.Controller;

import android.widget.Toast;

import androidx.annotation.NonNull;

import com.clau.gastosapp.activitys.DetalleMesFinalizado;
import com.clau.gastosapp.objetos.Gasto;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetalleMesFinalizadoController {

    private DetalleMesFinalizado vista;
    private String idMes;

    public DetalleMesFinalizadoController(DetalleMesFinalizado vista) {
        this.vista = vista;
        this.idMes = idMes;
    }

    public void setIdMes(String idMes) {
        this.idMes = idMes;
        loadGastos(idMes);
    }

    public void setDatosMes(String mes, String descripcionMes, String estadoMes, Double totalGastosMes) {
        vista.mostrarDatos(mes, descripcionMes, estadoMes, totalGastosMes);
    }

    private void loadGastos(String mesId) {
        DatabaseReference gastosReference = FirebaseDatabase.getInstance().getReference("usuarios")
                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .child("meses").child(mesId).child("gastos");

        gastosReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    List<Gasto> listaGastos = new ArrayList<>();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Gasto gasto = snapshot.getValue(Gasto.class);
                        if (gasto != null) {
                            gasto.setId(snapshot.getKey());
                            listaGastos.add(gasto);
                        }
                    }
                    vista.actualizarListaGastos(listaGastos);
                } else {
                    Toast.makeText(vista, "No hay gastos en este mes", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(vista, "Error al leer los gastos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
