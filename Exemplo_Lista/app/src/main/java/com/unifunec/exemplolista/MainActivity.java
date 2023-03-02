package com.unifunec.exemplolista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.unifunec.exemplolista.dao.AlunoDAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this,"UNIFUNEC",Toast.LENGTH_LONG).show();


        FloatingActionButton fab = findViewById(R.id.addAluno);
        AlunoDAO dao = new AlunoDAO();

        setTitle("Lista de Alunos");

        //Simulação de uma Consulta de Alunos cadastrados em um banco
        List<String> alunos = new ArrayList<>(
                Arrays.asList("Marcos", "Otoni","Codinhoto","Marcela")
        );

        ListView lista_Alunos = findViewById(R.id.lst_Alunos);
        lista_Alunos.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,dao.todos()));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,Formulario_DadosActivity.class));
            }
        });
    }
}