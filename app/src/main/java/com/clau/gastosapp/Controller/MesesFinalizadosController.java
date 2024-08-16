package com.clau.gastosapp.Controller;

import androidx.annotation.NonNull;

import com.clau.gastosapp.Model.MesModel;
import com.clau.gastosapp.activitys.MesesFinalizados;
import com.clau.gastosapp.objetos.Mes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

// MesesFinalizadosController.java
public class MesesFinalizadosController {

    private MesModel mesModel;
    private MesesFinalizados view;

    public MesesFinalizadosController(MesesFinalizados view) {
        this.view = view;
        this.mesModel = new MesModel();
    }

    public void loadMesesFinalizados() {
        mesModel.getMesesFinalizados(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List<Mes> mesesFinalizadosList = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Mes mes = snapshot.getValue(Mes.class);
                    if (mes != null) {
                        mes.setIdMes(snapshot.getKey());
                        mesesFinalizadosList.add(mes);
                    }
                     else{
                        view.mensajeToast("No hay meses finalizados");

                    }
                }
                view.updateMesesFinalizados(mesesFinalizadosList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                view.mensajeToast("Error al cargar los datos");
            }
        });
    }
    public void eliminarMes(String mesId) {
        if (mesId == null || mesId.isEmpty()) {
            view.mensajeToast("No se ha encontrado el mes en curso.");
            return;
        }

        mesModel.eliminarMes(mesId, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    view.mensajeToast("Mes eliminado");
                    loadMesesFinalizados();
                } else {
                    view.mensajeToast("Error al eliminar el mes");
                }
            }
        });
    }
}
