package com.example.alunosunifunec;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.alunosunifunec.modelo.Alunos;

import java.util.List;

public class AlunosAdapter extends ArrayAdapter<Alunos> {

    private List<Alunos> items;

    public AlunosAdapter(Context context, int LayoutAdapter_ViewResourceId, List<Alunos> items) {
        super(context, LayoutAdapter_ViewResourceId, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            Context ctx = getContext();
            LayoutInflater vi = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.item_aluno, null);
        }
        Alunos alunos = items.get(position);
        if (alunos != null) {
            ((TextView) v.findViewById(R.id.txt_codigo)).setText(""+alunos.getCodaluno());
            ((TextView) v.findViewById(R.id.txt_nome)).setText(alunos.getNomealuno());
            ((TextView) v.findViewById(R.id.txt_curso)).setText(alunos.getCurso());
        }
        return v;
    }
}
