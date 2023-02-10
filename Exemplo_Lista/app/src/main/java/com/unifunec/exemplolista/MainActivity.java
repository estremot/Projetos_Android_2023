package com.unifunec.exemplolista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toast.makeText(this,"UNIFUNEC",Toast.LENGTH_LONG).show();
        setTitle("Lista de Alunos");

        //Simulação de uma Consulta de Alunos cadastrados em um banco
        List<String> alunos = new ArrayList<>(
                Arrays.asList("Marcos", "Otoni","Codinhoto","Marcela")
        );

        ListView lista_Alunos = findViewById(R.id.lst_Alunos);
        lista_Alunos.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,alunos));
    }
}