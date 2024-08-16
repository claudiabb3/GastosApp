package com.clau.gastosapp.Controller;


import android.content.Intent;
import com.clau.gastosapp.activitys.DetalleGasto;
import com.clau.gastosapp.activitys.DetalleMesFinalizado;
import com.clau.gastosapp.activitys.Mescurso;


public class DetalleGastoController {

    private final DetalleGasto view;
    private String imagenUrl;
    private String actividadAnterior;

    public DetalleGastoController(DetalleGasto view) {
        this.view = view;
    }

    public void cargarDatosDesdeIntent(Intent intent) {
        // Obtener los datos del Intent
        String descripcion = intent.getStringExtra("descripcion");
        double cantidad = intent.getDoubleExtra("cantidad", 0.00);
        String fecha = intent.getStringExtra("fecha");
        imagenUrl = intent.getStringExtra("imagenUrl");
        actividadAnterior = intent.getStringExtra("activity");

        // Mostrar los datos en la vista
        view.mostrarDatos(descripcion, cantidad, fecha);
    }

    public void mostrarImagen() {
        view.mostrarImagen(imagenUrl);
    }

    public void handleBackPressed() {
        if (actividadAnterior != null && !actividadAnterior.trim().isEmpty()) {
            Intent intent;

            switch (actividadAnterior) {
                case "DetalleMesFinalizado":
                    intent = new Intent(view, DetalleMesFinalizado.class);
                    rellenarIntentConDatosMes(view.getIntent(), intent);
                    break;
                case "Mescurso":
                    intent = new Intent(view, Mescurso.class);
                    break;
                default:
                    view.finish();
                    return;
            }

            view.startActivity(intent);
            view.finish();
        } else {
            view.finish();
        }
    }

    private void rellenarIntentConDatosMes(Intent originalIntent, Intent nuevoIntent) {
        nuevoIntent.putExtra("mes", originalIntent.getStringExtra("mes"));
        nuevoIntent.putExtra("descripcionMes", originalIntent.getStringExtra("descripcionMes"));
        nuevoIntent.putExtra("estadoMes", originalIntent.getStringExtra("estadoMes"));
        nuevoIntent.putExtra("totalGastosMes", originalIntent.getIntExtra("totalGastosMes", 0));
        nuevoIntent.putExtra("idMes", originalIntent.getStringExtra("idMes"));
    }
}
