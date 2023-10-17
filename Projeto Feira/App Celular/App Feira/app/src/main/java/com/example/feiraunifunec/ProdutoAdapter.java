package com.example.feiraunifunec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.feiraunifunec.modelo.Produto;


import java.util.List;

public class ProdutoAdapter extends ArrayAdapter<Produto> {

    private List<Produto> items;

    public ProdutoAdapter(Context context, int LayoutAdapter_ViewResourceId, List<Produto> items) {
        super(context, LayoutAdapter_ViewResourceId, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            Context ctx = getContext();
            LayoutInflater vi = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.item_produto, null);
         }
        Produto produto = items.get(position);
        if (produto != null) {
            ((TextView) v.findViewById(R.id.txt_codigo)).setText(""+produto.getCodproduto());
            ((TextView) v.findViewById(R.id.txt_nome)).setText(produto.getNomeproduto());
            ((TextView) v.findViewById(R.id.txt_quantidade)).setText(produto.getQuantidade()+"");
            ((TextView) v.findViewById(R.id.txt_valor)).setText(produto.getValor()+"");
            //((TextView) v.findViewById(R.id.txt_tipo)).setText(produto.getTipo().getNometipo());
        }
        return v;
    }
}
