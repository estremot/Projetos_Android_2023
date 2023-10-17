package com.example.feiraunifunec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.feiraunifunec.asynctask.BaseAsyncTask;
import com.example.feiraunifunec.feiraretrofit.FeiraRetrofit;
import com.example.feiraunifunec.feiraretrofit.service.ProdutoService;
import com.example.feiraunifunec.modelo.Produto;
import com.example.feiraunifunec.modelo.Tipo;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivityProduto extends AppCompatActivity {

    private TextView tt = null;
    List<Produto> produtoNovos = null;
    ListView lista = null;

    ArrayList<Produto> array_produtos;


    @Override
    protected void onResume() {
        super.onResume();
        buscaProdutos();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainproduto);

        FloatingActionButton btnInserir = findViewById(R.id.btn_Inserir);

         lista = findViewById(R.id.listaProdutos);

         btnInserir.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent it = new Intent(MainActivityProduto.this, InserirDadosTipo.class);
                 startActivity(it);
             }
         });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicao, long id) {
                //Toast.makeText(MainActivity.this, "Fera", Toast.LENGTH_SHORT).show();

                //Log.i("Posicao", "cliquei: "+posicao);
                Produto produtoSelecionado = produtoNovos.get(posicao);
                Intent it = new Intent(MainActivityProduto.this, DadosProduto.class);
                it.putExtra("produto",produtoSelecionado);
                startActivity(it);
            }
        });

        buscaProdutos();
    }


    private void buscaProdutos(){
        try{
            //Configurar as permissões de acesso ao retrofit
        ProdutoService service = new FeiraRetrofit().getProdutoService();
        Call<List<Produto>> call = service.buscaTodos();

       // List<Amigos> dados = new ArrayList<Amigos>();
            new BaseAsyncTask<>(() -> {
                try {
                    Response<List<Produto>> resposta = call.execute();
                   produtoNovos = resposta.body();
                    return produtoNovos;
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }

            }, amigosNovos -> {
                if (amigosNovos != null) {
                    //tt.setText("Acessei o Server");

                    array_produtos = (ArrayList<Produto>) produtoNovos;
                    ProdutoAdapter adapter =
                            new ProdutoAdapter(getBaseContext(), R.layout.item_produto, array_produtos);
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