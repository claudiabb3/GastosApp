package com.clau.gastosapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.clau.gastosapp.Controller.MesesFinalizadosController;
import com.clau.gastosapp.R;
import com.clau.gastosapp.adapters.MesAdapter;
import com.clau.gastosapp.objetos.Mes;

import java.util.ArrayList;
import java.util.List;

// MesesFinalizados.java
public class MesesFinalizados extends AppCompatActivity {

    private ListView lvMeses;
    private MesAdapter mesAdapter;
    private List<Mes> mesesFinalizadosList = new ArrayList<>();
    private MesesFinalizadosController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meses_finalizados);

        inicializar();
        controller.loadMesesFinalizados();
        clicListView();

    }

    private void inicializar() {
        controller = new MesesFinalizadosController(this);
        lvMeses = findViewById(R.id.lvMeses);
        mesAdapter = new MesAdapter(this, mesesFinalizadosList);
        lvMeses.setAdapter(mesAdapter);
    }

    private void clicListView() {
        lvMeses.setOnItemClickListener((parent, view, position, id) -> {
            Mes mesSeleccionado = mesesFinalizadosList.get(position);

            if (mesSeleccionado.getIdMes() != null) {
                Intent intent = new Intent(MesesFinalizados.this, DetalleMesFinalizado.class);
                intent.putExtra("mes", mesSeleccionado.getMes());
                intent.putExtra("descripcionMes", mesSeleccionado.getDescripcion());
                intent.putExtra("estadoMes", mesSeleccionado.getEstado());
                intent.putExtra("totalGastosMes", mesSeleccionado.getTotalGastos());
                intent.putExtra("idMes", mesSeleccionado.getIdMes());
                startActivity(intent);
            } else {
                Toast.makeText(MesesFinalizados.this, "ID del mes no disponible", Toast.LENGTH_SHORT).show();
            }
        });

        lvMeses.setOnItemLongClickListener((parent, view, position, id) -> {
            if (position >= 0 && position < mesesFinalizadosList.size()) {
                Mes mesSeleccionado = mesesFinalizadosList.get(position);

                // Mostrar un diálogo de confirmación
                new AlertDialog.Builder(MesesFinalizados.this)
                        .setTitle("Eliminar Mes")
                        .setMessage("¿Estás seguro de que deseas eliminar este mes?")
                        .setPositiveButton("Sí", (dialog, which) -> {
                            controller.eliminarMes(mesSeleccionado.getIdMes());
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
            return false;
        });
    }

    public void updateMesesFinalizados(List<Mes> meses) {
        mesesFinalizadosList.clear();
        mesesFinalizadosList.addAll(meses);
        mesAdapter.notifyDataSetChanged();
    }

    public void mensajeToast(String mensaje) {
        Toast.makeText(MesesFinalizados.this, mensaje, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(MesesFinalizados.this, Inicio.class);
        startActivity(intent);
        finish();
    }
}
