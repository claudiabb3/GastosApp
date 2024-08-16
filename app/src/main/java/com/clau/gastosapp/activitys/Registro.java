package com.clau.gastosapp.activitys;


import android.content.Intent;
        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;
        import androidx.appcompat.app.AppCompatActivity;
        import com.clau.gastosapp.Controller.UsuarioController;
        import com.clau.gastosapp.Interface.UsuarioView;
        import com.clau.gastosapp.Model.UsuarioModel;
        import com.clau.gastosapp.R;

public class Registro extends AppCompatActivity implements UsuarioView {

    private EditText txtNombre;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnRegistrar;
    private Button btnCancelar;
    private UsuarioController usuarioController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        inicializar();
        configurarBotones();
    }

    private void inicializar() {
        usuarioController = new UsuarioController(this, new UsuarioModel());
        txtNombre = findViewById(R.id.txtnombre);
        txtEmail = findViewById(R.id.txtemail);
        txtPassword = findViewById(R.id.txtpassword);
        btnRegistrar = findViewById(R.id.btnregistrar);
        btnCancelar = findViewById(R.id.btncancelar);
    }

    private void configurarBotones() {
        btnCancelar.setOnClickListener(v -> {
            Intent intent = new Intent(Registro.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        btnRegistrar.setOnClickListener(v -> usuarioController.registrarUsuario(
                txtNombre.getText().toString().trim(),
                txtEmail.getText().toString().trim(),
                txtPassword.getText().toString().trim()
        ));
    }

    @Override
    public void mensajeError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void volverMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onBackPressed() {
    }
}
