package com.clau.gastosapp.Controller;

import com.clau.gastosapp.Interface.UsuarioView;
import com.clau.gastosapp.Model.UsuarioModel;
import com.google.firebase.auth.FirebaseUser;

public class UsuarioController {

    private UsuarioView view;
    private UsuarioModel model;

    public UsuarioController(UsuarioView view, UsuarioModel model) {
        this.view = view;
        this.model = model;
    }

    public void actualizarUsuario(String nombre, String email, String contraseña) {
        model.actualizarUsuario(nombre, email, contraseña, new UsuarioModel.OnUsuarioActualizadoListener() {
            @Override
            public void onSuccess(String mensaje) {
                view.mensajeError(mensaje); // Puedes cambiar a showSuccess si hay un método para ello.
            }

            @Override
            public void onError(String mensaje) {
                view.mensajeError(mensaje);
            }
        });
    }

    public void registrarUsuario(String nombre, String email, String password) {
        if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
            view.mensajeError("Debes rellenar todos los campos");
            return;
        }

        model.getAuth().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = model.getCurrentUser();
                        if (user != null) {
                            enviarVerificacionYActualizarPerfil(user, nombre);
                        } else {
                            manejarError("No se pudo obtener el usuario después del registro.");
                        }
                    } else {
                        manejarError(task.getException() != null ? task.getException().getMessage() : "Error en el registro");
                    }
                });
    }

    private void enviarVerificacionYActualizarPerfil(FirebaseUser user, String nombre) {
        model.sendEmailVerification(user)
                .addOnCompleteListener(verificationTask -> {
                    if (verificationTask.isSuccessful()) {
                        actualizarPerfil(user, nombre);
                    } else {
                        manejarError("Error al enviar el correo de verificación");
                    }
                });
    }

    private void actualizarPerfil(FirebaseUser user, String nombre) {
        model.updateProfile(user, nombre)
                .addOnCompleteListener(profileTask -> {
                    if (profileTask.isSuccessful()) {
                        view.mensajeError("Registro exitoso. Verifica tu correo para completar la inscripción.");
                        view.volverMainActivity();
                    } else {
                        manejarError("Error al actualizar el perfil");
                    }
                });
    }

    private void manejarError(String mensaje) {
        view.mensajeError(mensaje);
    }

    public void eliminarUsuario() {
        model.eliminarUsuario(new UsuarioModel.OnUsuarioActualizadoListener() {
            @Override
            public void onSuccess(String mensaje) {
                view.mensajeError(mensaje); // Puedes cambiar a showSuccess si hay un método para ello.
                view.volverMainActivity();
            }

            @Override
            public void onError(String mensaje) {
                view.mensajeError(mensaje);
            }
        });
    }
}
