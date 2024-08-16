package com.clau.gastosapp.activitys;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.clau.gastosapp.Controller.NuevoMesController;
import com.clau.gastosapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

// NuevoMes.java
public class NuevoMes extends AppCompatActivity {

    private EditText edtDescripcion;
    private Spinner spinnerMes;
    private Button btnAceptar;
    private Button btnCancelar;
    private NuevoMesController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_mes);

        inicializar();
        spinnerMeses();
        controller = new NuevoMesController(this);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            btnAceptar.setOnClickListener(v -> controller.handleAceptarClick());
            btnCancelar.setOnClickListener(v -> controller.handleCancelarClick());
        }
    }

    private void inicializar() {
        edtDescripcion = findViewById(R.id.edtDescripcion);
        spinnerMes = findViewById(R.id.spinnerMes);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
    }

    private void spinnerMeses() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.meses_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMes.setAdapter(adapter);
    }

    public String getDescripcion() {
        return edtDescripcion.getText().toString().trim();
    }

    public String getMes() {
        return spinnerMes.getSelectedItem().toString();
    }

    public void mensajeToast(String message) {
        Toast.makeText(NuevoMes.this, message, Toast.LENGTH_SHORT).show();
    }

    public void volverInicio() {
        Intent intent = new Intent(NuevoMes.this, Inicio.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        volverInicio();
    }
}
