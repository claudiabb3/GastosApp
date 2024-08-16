package com.clau.gastosapp.activitys;
import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.clau.gastosapp.Controller.AddGastoController;
import com.clau.gastosapp.R;


public class AddGasto extends AppCompatActivity {
    private AddGastoController controller;
    private EditText edtDescripcionGasto, edtImporteGasto;
    private TextView tvFechaGasto;
    private ImageView imgFotoGasto;
    private ProgressDialog progressDialog;
    private Uri fotoUri;

    public static final int PICK_IMAGE_REQUEST = 1;
    public static final int PERMISSION_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gasto);

        inicializar();
        controller = new AddGastoController(this);
        setupListeners();
    }

    private void inicializar() {
        edtDescripcionGasto = findViewById(R.id.edtDescripcionGasto);
        edtImporteGasto = findViewById(R.id.edtImporteGasto);
        tvFechaGasto = findViewById(R.id.tvFechaGasto);
        imgFotoGasto = findViewById(R.id.imgFotoGasto);
        ImageButton btnSeleccionarFecha = findViewById(R.id.btnSeleccionarFecha);
        ImageButton btnSeleccionarFoto = findViewById(R.id.btnSeleccionarFoto);
        Button btnGuardarGasto = findViewById(R.id.btnGuardarGasto);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Guardando gasto...");
        progressDialog.setCancelable(false);

        // Botones manejados por el controlador
        btnSeleccionarFecha.setOnClickListener(v -> controller.showDatePicker());
        btnSeleccionarFoto.setOnClickListener(v -> controller.selectPhoto());
        btnGuardarGasto.setOnClickListener(v -> controller.saveGasto());
    }

    private void setupListeners() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    public String getDescripcionGasto() {
        return edtDescripcionGasto.getText().toString().trim();
    }

    public double getImporteGasto() {
        String importeStr = edtImporteGasto.getText().toString().trim();
        return importeStr.isEmpty() ? 0 : Double.parseDouble(importeStr);
    }

    public String getFechaGasto() {
        return tvFechaGasto.getText().toString().trim();
    }

    public void mostrarFecha(String fecha) {
        tvFechaGasto.setText(fecha);
    }

    public void mostrarImagen(Uri uri) {
        imgFotoGasto.setImageURI(uri);
        fotoUri = uri;
    }

    public void mostrarMensaje(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    public void mostrarProgreso() {
        progressDialog.show();
    }

    public void ocultarProgreso() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null && requestCode == PICK_IMAGE_REQUEST) {
            Uri selectedImageUri = data.getData();
            controller.onImageSelected(selectedImageUri);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        controller.handlePermissionsResult(requestCode, grantResults);
    }

    public Uri getFotoUri() {
        return fotoUri;
    }
}
