package com.clau.gastosapp.Model;



import com.clau.gastosapp.objetos.Mes;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MesModel {

    private DatabaseReference databaseReference;

    public MesModel() {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String userId = currentUser.getUid();
            databaseReference = FirebaseDatabase.getInstance().getReference("usuarios").child(userId).child("meses");
        }
    }

    public DatabaseReference getDatabaseReference() {
        return databaseReference;
    }

    public void getMesesFinalizados(ValueEventListener listener) {
        databaseReference.orderByChild("estado").equalTo("finalizado").addValueEventListener(listener);
    }
    public void getMesEnCurso(ValueEventListener listener) {
        databaseReference.orderByChild("estado").equalTo("enCurso").limitToLast(1)
                .addListenerForSingleValueEvent(listener);
    }

    public void getGastos(String mesId, ValueEventListener listener) {
        databaseReference.child(mesId).child("gastos").addValueEventListener(listener);
    }

    public void finalizarMes(String mesId, DatabaseReference.CompletionListener completionListener) {
        databaseReference.child(mesId).child("estado").setValue("finalizado", completionListener);
    }

    public void eliminarGasto(String mesId, String gastoId, DatabaseReference.CompletionListener completionListener) {
        databaseReference.child(mesId).child("gastos").child(gastoId).removeValue(completionListener);
    }
    public void eliminarMes(String mesId, DatabaseReference.CompletionListener completionListener) {
        databaseReference.child(mesId).removeValue(completionListener);
    }
    public void createMes(Mes mes, DatabaseReference.CompletionListener listener) {
        String mesId = databaseReference.push().getKey();
        if (mesId != null) {
            databaseReference.child(mesId).setValue(mes, listener);
        }
    }

    public void checkExistingMes(ValueEventListener listener) {
        databaseReference.orderByChild("estado").equalTo("enCurso").addListenerForSingleValueEvent(listener);
    }
}

