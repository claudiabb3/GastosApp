package com.clau.gastosapp.Model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class AuthModel {
    private FirebaseAuth auth;

    public AuthModel() {
        auth = FirebaseAuth.getInstance();
    }

    public interface OnSignInListener {
        void onSuccess(FirebaseUser user);
        void onError(String errorMessage);
    }

    public interface ResetPass {
        void onSuccess();
        void onError(String errorMessage);
    }

    public void signIn(String email, String password, OnSignInListener listener) {

        if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
            listener.onError("Debes indicar el correo y la contraseña.");

        }else {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = auth.getCurrentUser();
                        if (user != null) {
                            if (user.isEmailVerified()) {
                                listener.onSuccess(user);
                            } else {
                                auth.signOut(); // Cerrar sesión si el correo no está verificado
                                listener.onError("Debes verificar tu correo electrónico antes de iniciar sesión.");
                            }
                        } else {
                            listener.onError("No se pudo obtener el usuario.");
                        }
                    } else {
                        listener.onError(task.getException().getMessage());
                    }
                });
    }}

    public void sendPasswordResetEmail(String email, ResetPass listener) {
        auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        listener.onSuccess();
                    } else {
                        listener.onError(task.getException().getMessage());
                    }
                });
    }
}

