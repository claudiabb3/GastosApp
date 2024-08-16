package com.clau.gastosapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.clau.gastosapp.R;
import com.clau.gastosapp.objetos.Mes;

import java.util.List;

public class MesAdapter extends BaseAdapter {

    private Context context;
    private List<Mes> mesesList;

    public MesAdapter(Context context, List<Mes> mesesList) {
        this.context = context;
        this.mesesList = mesesList;
    }

    @Override
    public int getCount() {
        return mesesList.size();
    }

    @Override
    public Object getItem(int position) {
        return mesesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_meses, parent, false);
        }

        Mes mes = mesesList.get(position);

        TextView tvMes = convertView.findViewById(R.id.tvMes);
        TextView tvTotalGastos = convertView.findViewById(R.id.tvTotal);

        tvMes.setText(mes.getMes());
        tvTotalGastos.setText(mes.getTotalGastos() + " €");

        return convertView;
    }
}
