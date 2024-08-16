
package com.clau.gastosapp.activitys;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.clau.gastosapp.Controller.AuthController;
import com.clau.gastosapp.Model.AuthModel;
import com.clau.gastosapp.R;
import com.google.firebase.auth.FirebaseUser;

    public class MainActivity extends AppCompatActivity implements AuthModel.OnSignInListener {
        private EditText txtmail;
        private EditText txtpass;
        private Button btnIniciarSesion;
        private TextView registrarme,recuperarPass;

        private AuthController authController;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            inicializar();
            iniciarSesion();
            registrar();
            recupararPass();




        }

        private void inicializar() {
            authController = new AuthController(new AuthModel(), this);
            txtmail = findViewById(R.id.txtmail);
            txtpass = findViewById(R.id.txtpass);
            btnIniciarSesion = findViewById(R.id.btnIniciarSesion);
            registrarme = findViewById(R.id.registrarme);
            recuperarPass = findViewById(R.id.recuperarPass);
        }

        private void iniciarSesion(){

            btnIniciarSesion.setOnClickListener(v -> {
                String email = txtmail.getText().toString().trim();
                String password = txtpass.getText().toString().trim();
                authController.signIn(email, password);
            });

        }

        private void registrar(){
            registrarme.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Registro.class);
                startActivity(intent);
            });
        }

        private void recupararPass(){
            recuperarPass.setOnClickListener(v -> {
                String email = txtmail.getText().toString().trim();
                if (!email.isEmpty()) {
                    btnIniciarSesion.setEnabled(false);
                    authController.sendPasswordResetEmail(email);
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, ingrese su correo electrónico", Toast.LENGTH_SHORT).show();
                }
            });
        }
        @Override
        public void onSuccess(FirebaseUser user) {
            Intent intent = new Intent(MainActivity.this, Inicio.class);
            startActivity(intent);
            finish();
        }

        @Override
        public void onError(String errorMessage) {

            btnIniciarSesion.setEnabled(true);
            Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
        }

        public void onPasswordResetSuccess() {

            btnIniciarSesion.setEnabled(true);
            Toast.makeText(MainActivity.this, "Correo de recuperación enviado. Verifique su correo electrónico.", Toast.LENGTH_LONG).show();
        }

        public void onPasswordResetError(String errorMessage) {

            btnIniciarSesion.setEnabled(true);
            Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
        }
    }