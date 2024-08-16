package com.clau.gastosapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.clau.gastosapp.R;
import com.clau.gastosapp.objetos.Gasto;

import java.util.List;

public class listaGastoAdapter extends BaseAdapter {

    private Context context;
    private List<Gasto> gastos;

    public listaGastoAdapter(Context context, List<Gasto> gastos) {
        this.context = context;
        this.gastos = gastos;
    }

    @Override
    public int getCount() {
        return gastos.size();
    }

    @Override
    public Object getItem(int position) {
        return gastos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.item_gasto, parent, false);
        }

        // Obtener referencias a las vistas del layout `item_gasto.xml`
        TextView tvDescripcion = convertView.findViewById(R.id.tvDescripcion);
        TextView tvCantidad = convertView.findViewById(R.id.tvCantidad);


        // Obtener el gasto actual
        Gasto gasto = gastos.get(position);

        // Rellenar las vistas con los datos del gasto
        tvDescripcion.setText(gasto.getDescripcion());
        tvCantidad.setText(String.valueOf(gasto.getCantidad() + " €"));



        return convertView;
    }
}
