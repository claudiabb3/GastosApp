package com.clau.gastosapp.Controller;

import com.clau.gastosapp.Model.UsuarioModel;
import com.clau.gastosapp.R;
import com.clau.gastosapp.activitys.Inicio;
import com.google.firebase.auth.FirebaseUser;

public class InicioController {
    private UsuarioModel usuarioModel;
    private Inicio view;

    public InicioController(Inicio view) {
        this.usuarioModel = new UsuarioModel();
        this.view = view;
    }

    public void saludo() {
        FirebaseUser user = usuarioModel.getCurrentUser();
        if (user != null) {
            String displayName = user.getDisplayName();
            if (displayName != null) {
                view.mostrarSaludo("Bienvenid@, " + displayName);
            } else {
                view.mostrarSaludo("Bienvenid@");
            }
        }
    }

    public void cerrarSesion() {
        usuarioModel.cerrarSesion();
        view.redirigirALogin();
    }

    public void gestionarRedirecciones(int idBoton) {
        if (idBoton == R.id.btnmesnuevo) {
            view.redirigirANuevoMes();
        } else if (idBoton == R.id.btnmescurso) {
            view.redirigirAMesCurso();
        } else if (idBoton == R.id.btnmesesantiguos) {
            view.redirigirAMesesAntiguos();
        } else if (idBoton == R.id.btnConfigurar) {
            view.redirigirAConfiguracion();
        }
    }

    public boolean usuarioAutenticado() {
        return usuarioModel.getCurrentUser() != null;
    }
}

