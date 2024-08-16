package com.clau.gastosapp.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.clau.gastosapp.Controller.InicioController;
import com.clau.gastosapp.Interface.InicioView;
import com.clau.gastosapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
public class Inicio extends AppCompatActivity implements InicioView {

    private ImageButton btnmescurso, btnmesnuevo, btnConfigurar, btnmesesantiguos;
    private Button btncerrarsesion;
    private TextView nombre;

    private InicioController controller;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        inicializar();
        controller.saludo();
        configurarBotones();
    }

    private void inicializar() {

        controller = new InicioController(this);
        btnmescurso = findViewById(R.id.btnmescurso);
        btnmesnuevo = findViewById(R.id.btnmesnuevo);
        btnmesesantiguos = findViewById(R.id.btnmesesantiguos);
        btncerrarsesion = findViewById(R.id.btncerrarsesion);
        btnConfigurar = findViewById(R.id.btnConfigurar);
        nombre = findViewById(R.id.nombre);
    }

    private void configurarBotones() {
        btncerrarsesion.setOnClickListener(v -> controller.cerrarSesion());
        View.OnClickListener onClickListener = v -> controller.gestionarRedirecciones(v.getId());
        btnmesnuevo.setOnClickListener(onClickListener);
        btnmescurso.setOnClickListener(onClickListener);
        btnmesesantiguos.setOnClickListener(onClickListener);
        btnConfigurar.setOnClickListener(onClickListener);
    }

    @Override
    public void mostrarSaludo(String mensaje) {
        nombre.setText(mensaje);
    }

    @Override
    public void redirigirALogin() {
        Intent intent = new Intent(Inicio.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void redirigirANuevoMes() {
        if (controller.usuarioAutenticado()) {
            Intent intent = new Intent(Inicio.this, NuevoMes.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void redirigirAMesCurso() {
        if (controller.usuarioAutenticado()) {
            Intent intent = new Intent(Inicio.this, Mescurso.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void redirigirAMesesAntiguos() {
        Intent intent = new Intent(Inicio.this, MesesFinalizados.class);
        startActivity(intent);
    }

    @Override
    public void redirigirAConfiguracion() {
        Intent intent = new Intent(Inicio.this, Configurar.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
    }
}