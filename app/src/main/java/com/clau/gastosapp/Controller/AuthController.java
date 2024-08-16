package com.clau.gastosapp.Controller;

import com.clau.gastosapp.Model.AuthModel;
import com.clau.gastosapp.activitys.MainActivity;

public class AuthController {
    private AuthModel authModel;
    private AuthModel.OnSignInListener listener;

    public AuthController(AuthModel authModel, AuthModel.OnSignInListener listener) {
        this.authModel = authModel;
        this.listener = listener;
    }

    public void signIn(String email, String password) {
        authModel.signIn(email, password, listener);
    }

    public void sendPasswordResetEmail(String email) {
        authModel.sendPasswordResetEmail(email, new AuthModel.ResetPass() {
            @Override
            public void onSuccess() {
                if (listener instanceof MainActivity) {
                    ((MainActivity)listener).onPasswordResetSuccess();
                }
            }

            @Override
            public void onError(String errorMessage) {
                if (listener instanceof MainActivity) {
                    ((MainActivity)listener).onPasswordResetError(errorMessage);
                }
            }
        });
    }
}




