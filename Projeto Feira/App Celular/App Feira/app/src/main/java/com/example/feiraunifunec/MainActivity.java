package com.example.feiraunifunec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.feiraunifunec.feiraretrofit.FeiraRetrofit;

import com.example.feiraunifunec.asynctask.BaseAsyncTask;
import com.example.feiraunifunec.feiraretrofit.service.TipoService;

import com.example.feiraunifunec.modelo.Tipo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tt = null;
    List<Tipo> tipoNovos = null;
    ListView lista = null;

    ArrayList<Tipo> array_alunos;


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

        FloatingActionButton frm_produtos = findViewById(R.id.btn_Produtos);

        frm_produtos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, MainActivityProduto.class);
                startActivity(it);
            }
        });

         lista = findViewById(R.id.listaProdutos);

         btnInserir.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent it = new Intent(MainActivity.this, InserirDadosTipo.class);
                 startActivity(it);
             }
         });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                //Toast.makeText(MainActivity.this, "Fera", Toast.LENGTH_SHORT).show();

                //Log.i("Posicao", "cliquei: "+posicao);
                Tipo alunoSelecionado = tipoNovos.get(posicao);
                Intent it = new Intent(MainActivity.this, DadosTipo.class);
                it.putExtra("aluno",alunoSelecionado);
                startActivity(it);
            }
        });

        buscaAmigos();
    }


    private void buscaAmigos(){
        try{
            //Configurar as permissões de acesso ao retrofit
        TipoService service = new FeiraRetrofit().getTipoService();
        Call<List<Tipo>> call = service.buscaTodos();

       // List<Amigos> dados = new ArrayList<Amigos>();
            new BaseAsyncTask<>(() -> {
                try {
                    Response<List<Tipo>> resposta = call.execute();
                   tipoNovos = resposta.body();
                    return tipoNovos;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }

            }, amigosNovos -> {
                if (amigosNovos != null) {
                    //tt.setText("Acessei o Server");

                    array_alunos = (ArrayList<Tipo>) amigosNovos;
                    TipoAdapter adapter =
                            new TipoAdapter(getBaseContext(), R.layout.item_tipo, array_alunos);
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