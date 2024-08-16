package com.clau.gastosapp.activitys;



import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.clau.gastosapp.Controller.MesCursoController;
import com.clau.gastosapp.R;
import com.clau.gastosapp.adapters.listaGastoAdapter;
import com.clau.gastosapp.objetos.Gasto;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;


public class Mescurso extends AppCompatActivity {

    private ListView lvGastos;
    private listaGastoAdapter gastoAdapter;
    private List<Gasto> listaGastos;
    private TextView tvMesEnCurso;
    private TextView txtGasto;
    FloatingActionButton fabAgregar;
    FloatingActionButton fabFinalizar;
    private MesCursoController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mescurso);


        inicializar();
        botones();
        controller.loadMesEnCurso();
        clickListView();
    }

    private void inicializar() {
        controller = new MesCursoController(this);
        listaGastos = new ArrayList<>();
        tvMesEnCurso = findViewById(R.id.tvMesEnCurso);
        txtGasto = findViewById(R.id.txtGasto);
        lvGastos = findViewById(R.id.lvGastos);
        fabAgregar = findViewById(R.id.fabAgregar);
        fabFinalizar = findViewById(R.id.fabFinalizar);

        gastoAdapter = new listaGastoAdapter(this, listaGastos);
        lvGastos.setAdapter(gastoAdapter);

    }

    private void botones(){

        fabAgregar.setOnClickListener(v -> {
            if (!tvMesEnCurso.getText().equals("Mes en curso")) {
                Intent intent = new Intent(Mescurso.this, AddGasto.class);
                startActivity(intent);
            } else {
                Toast.makeText(Mescurso.this, "No se puede añadir gastos, debes crear un mes", Toast.LENGTH_LONG).show();
            }
        });

        fabFinalizar.setOnClickListener(v -> {
            if (!tvMesEnCurso.getText().equals("Mes en curso")) {
                controller.finalizarMes();

            } else {
                Toast.makeText(Mescurso.this, "No hay mes en curso para finalizar", Toast.LENGTH_LONG).show();
            }
        });
    }
    private void clickListView() {
        lvGastos.setOnItemClickListener((parent, view, position, id) -> {
            if (position >= 0 && position < listaGastos.size()) {
                Gasto gastoSeleccionado = listaGastos.get(position);
                Intent intent = new Intent(Mescurso.this, DetalleGasto.class);
                intent.putExtra("descripcion", gastoSeleccionado.getDescripcion());
                intent.putExtra("cantidad", gastoSeleccionado.getCantidad());
                intent.putExtra("fecha", gastoSeleccionado.getFecha());
                intent.putExtra("imagenUrl", gastoSeleccionado.getImagenUrl());
                intent.putExtra("activity", "Mescurso");
                startActivity(intent);
            } else {
                Toast.makeText(Mescurso.this, "Ítem no válido", Toast.LENGTH_SHORT).show();
            }
        });

        lvGastos.setOnItemLongClickListener((parent, view, position, id) -> {
            if (position >= 0 && position < listaGastos.size()) {
                Gasto gastoSeleccionado = listaGastos.get(position);

                // Mostrar un diálogo de confirmación
                new AlertDialog.Builder(Mescurso.this)
                        .setTitle("Eliminar Gasto")
                        .setMessage("¿Estás seguro de que deseas eliminar este gasto?")
                        .setPositiveButton("Sí", (dialog, which) -> {
                            controller.eliminarGasto(gastoSeleccionado.getId());
                        })
                        .setNegativeButton("No", null)
                        .show();
                return true;
            }
            return false;
        });
    }

    public void cargarMesEnCurso(String mesNombre) {
            tvMesEnCurso.setText("Mes en Curso: " + mesNombre);
        }

    public void cargarGastos(List<Gasto> listaGastos, Double totalGastos) {
        this.listaGastos.clear();
        this.listaGastos.addAll(listaGastos);
        gastoAdapter.notifyDataSetChanged();
        txtGasto.setText(totalGastos + " €");
    }


    public void mensajeToast(String mensaje) {
            Toast.makeText(Mescurso.this, mensaje, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onBackPressed() {
            Intent intent = new Intent(Mescurso.this, Inicio.class);
            startActivity(intent);
            finish();
        }

    }