package com.example.feiraunifunec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.feiraunifunec.R;
import com.example.feiraunifunec.modelo.Tipo;

import java.util.List;

public class TipoAdapter extends ArrayAdapter<Tipo> {

    private List<Tipo> items;

    public TipoAdapter(Context context, int LayoutAdapter_ViewResourceId, List<Tipo> items) {
        super(context, LayoutAdapter_ViewResourceId, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            Context ctx = getContext();
            LayoutInflater vi = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.item_tipo, null);
        }
        Tipo tipo = items.get(position);
        if (tipo != null) {
            ((TextView) v.findViewById(R.id.txt_codigo)).setText(""+tipo.getCodtipo());
            ((TextView) v.findViewById(R.id.txt_nome)).setText(tipo.getNometipo());
        }
        return v;
    }
}
