package com.clau.gastosapp.activitys;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.clau.gastosapp.Controller.DetalleMesFinalizadoController;
import com.clau.gastosapp.R;

import com.clau.gastosapp.adapters.listaGastoAdapter;
import com.clau.gastosapp.objetos.Gasto;

import java.util.ArrayList;
import java.util.List;
public class DetalleMesFinalizado extends AppCompatActivity {

    private TextView tvMesValor, tvDescripcionValor, tvEstadoValor, tvTotalGastosValor;
    private ListView lvGastosFinalizados;
    private listaGastoAdapter gastoAdapter;
    private List<Gasto> listaGastosFinalizados;
    private DetalleMesFinalizadoController controller;

    private String descripcionMes,estadoMes,idMes,mes;
    private Double totalGastosMes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mes_finalizado);

        inicializar();
        obtenerDatosYmostrar();
        configurarClickListView();
    }

    private void inicializar() {

        tvMesValor = findViewById(R.id.tvMesValor);
        tvDescripcionValor = findViewById(R.id.tvDescripcionValor);
        tvEstadoValor = findViewById(R.id.tvEstadoValor);
        tvTotalGastosValor = findViewById(R.id.tvTotalGastosValor);
        lvGastosFinalizados = findViewById(R.id.lvGastosFinalizados);

        listaGastosFinalizados = new ArrayList<>();
        gastoAdapter = new listaGastoAdapter(this, listaGastosFinalizados);
        lvGastosFinalizados.setAdapter(gastoAdapter);

        controller = new DetalleMesFinalizadoController(this);
    }

    private void obtenerDatosYmostrar() {
         Intent intent = getIntent();
         mes = intent.getStringExtra("mes");
         descripcionMes = intent.getStringExtra("descripcionMes");
         estadoMes = intent.getStringExtra("estadoMes");
         totalGastosMes = intent.getDoubleExtra("totalGastosMes", 0.00);
         idMes = intent.getStringExtra("idMes");

        controller.setIdMes(idMes);
        controller.setDatosMes(mes, descripcionMes, estadoMes, totalGastosMes);
    }

    public void mostrarDatos(String mes, String descripcionMes, String estadoMes, Double totalGastosMes) {
        tvMesValor.setText( mes);
        tvDescripcionValor.setText(descripcionMes);
        tvEstadoValor.setText( estadoMes);
        tvTotalGastosValor.setText(totalGastosMes.toString() + " €");
    }

    public void actualizarListaGastos(List<Gasto> gastos) {
        listaGastosFinalizados.clear();
        listaGastosFinalizados.addAll(gastos);
        gastoAdapter.notifyDataSetChanged();
    }

    private void configurarClickListView() {
        lvGastosFinalizados.setOnItemClickListener((parent, view, position, id) -> {
            if (position >= 0 && position < listaGastosFinalizados.size()) {
                Gasto gastoSeleccionado = listaGastosFinalizados.get(position);
                Intent intent = new Intent(DetalleMesFinalizado.this, DetalleGasto.class);

                // Enviar datos del gasto
                intent.putExtra("descripcion", gastoSeleccionado.getDescripcion());
                intent.putExtra("cantidad", gastoSeleccionado.getCantidad());
                intent.putExtra("fecha", gastoSeleccionado.getFecha());
                intent.putExtra("imagenUrl", gastoSeleccionado.getImagenUrl());
                intent.putExtra("activity", "DetalleMesFinalizado");

                // Enviar datos del mes
                intent.putExtra("mes", mes);
                intent.putExtra("descripcionMes", descripcionMes);
                intent.putExtra("estadoMes", estadoMes);
                intent.putExtra("totalGastosMes", totalGastosMes);
                intent.putExtra("idMes", idMes);
                startActivity(intent);
            } else {
                Toast.makeText(DetalleMesFinalizado.this, "Ítem no válido", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(DetalleMesFinalizado.this, MesesFinalizados.class);
        startActivity(intent);
        finish();
    }
}