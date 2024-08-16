package com.clau.gastosapp.activitys;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.clau.gastosapp.Controller.DetalleGastoController;
import com.clau.gastosapp.R;
import com.squareup.picasso.Picasso;

public class DetalleGasto extends AppCompatActivity {
    private DetalleGastoController controller;
    private TextView tvDescripcion, tvCantidad, tvFecha;
    private ImageView imgGasto;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_gasto);

        inicializar();
        controller = new DetalleGastoController(this);

        // Llamar al controlador para cargar y mostrar los datos
        controller.cargarDatosDesdeIntent(getIntent());
        controller.mostrarImagen();
    }

    private void inicializar() {
        tvDescripcion = findViewById(R.id.tvDescripcion);
        tvCantidad = findViewById(R.id.tvCantidad);
        tvFecha = findViewById(R.id.tvFecha);
        imgGasto = findViewById(R.id.imgGasto);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando imagen...");
        progressDialog.setCancelable(false);
    }

    public void mostrarDatos(String descripcion, double cantidad, String fecha) {
        tvDescripcion.setText(descripcion);
        tvCantidad.setText(String.format("%.2f €", cantidad));
        tvFecha.setText(fecha);
    }

    public void mostrarImagen(String imagenUrl) {
        mostrarProgressDialog();

        if (imagenUrl != null && !imagenUrl.isEmpty()) {
            Picasso.get().load(imagenUrl).into(imgGasto, new com.squareup.picasso.Callback() {
                @Override
                public void onSuccess() {
                    finalizarProgressDialog();
                }

                @Override
                public void onError(Exception e) {
                    imgGasto.setImageResource(R.drawable.baseline_no_photography_24);
                    finalizarProgressDialog();
                }
            });
        } else {
            imgGasto.setImageResource(R.drawable.baseline_no_photography_24);
            finalizarProgressDialog();
        }
    }

    public void mostrarProgressDialog() {
        progressDialog.show();
    }

    public void finalizarProgressDialog() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onBackPressed() {
        controller.handleBackPressed();
    }
}
