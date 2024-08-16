package com.clau.gastosapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.clau.gastosapp.Controller.UsuarioController;
import com.clau.gastosapp.Interface.UsuarioView;
import com.clau.gastosapp.Model.UsuarioModel;
import com.clau.gastosapp.R;


public class Configurar extends AppCompatActivity implements UsuarioView {

    private EditText etNombre, etEmail, etContraseña;
    private Button btnAceptar, btnCancelar, btnEliminar;
    private UsuarioController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);

        inicializar();
        configurarBotones();
    }

    private void inicializar() {
        etNombre = findViewById(R.id.etNombre);
        etEmail = findViewById(R.id.etCorreo);
        etContraseña = findViewById(R.id.etContrasena);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnEliminar = findViewById(R.id.btnEliminarCuenta);

        controller = new UsuarioController(this, new UsuarioModel());
    }

    private void configurarBotones() {
        btnAceptar.setOnClickListener(v -> {
            String nombre = etNombre.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String contraseña = etContraseña.getText().toString().trim();
            controller.actualizarUsuario(nombre, email, contraseña);
            startActivity(new Intent(Configurar.this, Inicio.class));
            finish();
        });

        btnCancelar.setOnClickListener(v -> {
            startActivity(new Intent(Configurar.this, Inicio.class));
            finish();
        });

        btnEliminar.setOnClickListener(v -> new AlertDialog.Builder(this)
                .setTitle("Eliminar cuenta")
                .setMessage("¿Estás seguro de que deseas eliminar tu cuenta? Esta acción no se puede deshacer.")
                .setPositiveButton("Eliminar", (dialog, which) -> {
                    controller.eliminarUsuario();
                })
                .setNegativeButton("Cancelar", (dialog, which) -> {
                    dialog.dismiss();
                })
                .create()
                .show());
    }

    @Override
    public void mensajeError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void volverMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onBackPressed() {

    }
}

