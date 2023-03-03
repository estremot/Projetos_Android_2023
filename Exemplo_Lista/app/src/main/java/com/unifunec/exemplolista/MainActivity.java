package com.unifunec.exemplolista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.unifunec.exemplolista.dao.AlunoDAO;
import com.unifunec.exemplolista.model.Aluno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final AlunoDAO dao = new AlunoDAO();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mapeando o botão para chamar o Cadastro de Alunos

        FloatingActionButton fab = findViewById(R.id.addAluno);

        setTitle("Lista de Alunos");

        dao.salva(new Aluno("Marcos","18981871484","estremot@gmail.com"));
        dao.salva(new Aluno("Maria","18981871010","teste@gmail.com"));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Formulario_DadosActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        //https://developer.android.com/
        AlunoDAO dao = new AlunoDAO();

        configuraLista(dao);


    }

    private void configuraLista(AlunoDAO dao) {
        ListView lista_Alunos = findViewById(R.id.lst_Alunos);

        final List<Aluno> alunos = dao.todos();

        lista_Alunos.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, dao.todos()));

        lista_Alunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                Log.i("Posicao: ", " "+posicao);

                Aluno alunoEscolhido = alunos.get(posicao);
                Intent form = new Intent(MainActivity.this,Formulario_DadosActivity.class);
                form.putExtra("aluno", alunoEscolhido);
                startActivity(form);
            }
        });
    }
}