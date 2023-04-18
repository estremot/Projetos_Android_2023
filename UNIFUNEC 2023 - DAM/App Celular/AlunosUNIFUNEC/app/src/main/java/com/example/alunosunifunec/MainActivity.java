package com.example.alunosunifunec;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alunosunifunec.alunoretrofit.AlunoRetrofit;
import com.example.alunosunifunec.alunoretrofit.service.AlunoService;
import com.example.alunosunifunec.asynctask.BaseAsyncTask;
import com.example.alunosunifunec.modelo.Alunos;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tt = null;
    List<Alunos> amigosNovos = null;
    ListView lista = null;

    ArrayList<Alunos> array_alunos;


    @Override
    protected void onResume() {
        super.onResume();
        buscaAmigos();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton btnInserir = findViewById(R.id.btn_Inserir);

         lista = findViewById(R.id.listaAlunos);

         btnInserir.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent it = new Intent(MainActivity.this, InserirDados.class);
                 startActivity(it);
             }
         });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                //Toast.makeText(MainActivity.this, "Fera", Toast.LENGTH_SHORT).show();

                //Log.i("Posicao", "cliquei: "+posicao);
                Alunos alunoSelecionado = amigosNovos.get(posicao);
                Intent it = new Intent(MainActivity.this, DadosAluno.class);
                it.putExtra("aluno",alunoSelecionado);
                startActivity(it);
            }
        });

        buscaAmigos();
    }


    private void buscaAmigos(){
        try{
            //Configurar as permissões de acesso ao retrofit
        AlunoService service = new AlunoRetrofit().getAlunoService();
        Call<List<Alunos>> call = service.buscaTodos();

       // List<Amigos> dados = new ArrayList<Amigos>();
            new BaseAsyncTask<>(() -> {
                try {
                    Response<List<Alunos>> resposta = call.execute();
                   amigosNovos = resposta.body();
                    return amigosNovos;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }

            }, amigosNovos -> {
                if (amigosNovos != null) {
                    //tt.setText("Acessei o Server");

                    array_alunos = (ArrayList<Alunos>) amigosNovos;
                    AlunosAdapter adapter =
                            new AlunosAdapter(getBaseContext(), R.layout.item_aluno, array_alunos);
                    lista.setAdapter(adapter);


                } else {
                    Toast.makeText(this, "Não listou dados da API", Toast.LENGTH_LONG).show();
                }
            }).execute();
        }
        catch (Exception e){
            tt.setText("Implemente as permissões do dispositivo");
        }
    }


}