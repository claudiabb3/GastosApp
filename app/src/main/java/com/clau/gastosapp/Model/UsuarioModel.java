package com.clau.gastosapp.Model;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import java.util.ArrayList;
import java.util.List;
public class UsuarioModel {
    private FirebaseAuth auth;

    public UsuarioModel() {
        this.auth = FirebaseAuth.getInstance();
    }

    public void cerrarSesion() {
        auth.signOut();
    }
    public FirebaseAuth getAuth() {
        return auth;
    }

    public FirebaseUser getCurrentUser() {
        return auth.getCurrentUser();
    }

    public Task<Void> sendEmailVerification(FirebaseUser user) {
        return user.sendEmailVerification();
    }

    public Task<Void> updateProfile(FirebaseUser user, String name) {
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                .setDisplayName(name)
                .build();
        return user.updateProfile(profileUpdates);
    }

    public void actualizarUsuario(String nombre, String email, String contraseña, OnUsuarioActualizadoListener listener) {
        FirebaseUser usuario = auth.getCurrentUser();
        if (usuario != null) {
            List<Task<Void>> tasks = new ArrayList<>();

            if (nombre != null && !nombre.isEmpty()) {
                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                        .setDisplayName(nombre)
                        .build();
                tasks.add(usuario.updateProfile(profileUpdates));
            }

            if (email != null && !email.isEmpty()) {
                tasks.add(usuario.updateEmail(email));
            }

            if (contraseña != null && !contraseña.isEmpty()) {
                tasks.add(usuario.updatePassword(contraseña));
            }

            if (!tasks.isEmpty()) {
                Tasks.whenAllComplete(tasks).addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        listener.onSuccess("Usuario actualizado correctamente");
                    } else {
                        listener.onError("Error al actualizar el usuario");
                    }
                });
            } else {
                listener.onError("No se realizó ninguna actualización");
            }
        } else {
            listener.onError("Usuario no autenticado");
        }
    }

    public void eliminarUsuario(OnUsuarioActualizadoListener listener) {
        FirebaseUser usuario = auth.getCurrentUser();
        if (usuario != null) {
            usuario.delete().addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    listener.onSuccess("Usuario eliminado correctamente");
                } else {
                    listener.onError("Error al eliminar la cuenta");
                }
            });
        } else {
            listener.onError("Usuario no autenticado");
        }
    }

    public interface OnUsuarioActualizadoListener {
        void onSuccess(String mensaje);
        void onError(String mensaje);
    }
}


