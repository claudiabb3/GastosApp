package com.clau.gastosapp.Controller;

import androidx.annotation.NonNull;

import com.clau.gastosapp.Model.MesModel;
import com.clau.gastosapp.activitys.NuevoMes;
import com.clau.gastosapp.objetos.Mes;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

// NuevoMesController.java
public class NuevoMesController {

    private NuevoMes view;
    private MesModel mesModel;

    public NuevoMesController(NuevoMes view) {
        this.view = view;
        this.mesModel = new MesModel();
    }

    public void handleAceptarClick() {
        String descripcionStr = view.getDescripcion();
        String mesStr = view.getMes();


        if (descripcionStr.isEmpty() || mesStr.isEmpty()) {
            view.mensajeToast("Todos los campos son obligatorios");
            return;
        }

        mesModel.checkExistingMes(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    view.mensajeToast("Ya existe un mes en curso. Debes finalizarlo antes de crear uno nuevo.");
                } else {
                    Mes nuevoMes = new Mes(mesStr, descripcionStr, 0.00, "enCurso", null);
                    mesModel.createMes(nuevoMes, (error, ref) -> {
                        if (error == null) {
                            view.mensajeToast("Mes creado: " + mesStr);
                            view.volverInicio();
                        } else {
                            view.mensajeToast("Error al crear el mes");
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                view.mensajeToast("Error al verificar el estado del mes");
            }
        });
    }

    public void handleCancelarClick() {
        view.volverInicio();
    }
}

