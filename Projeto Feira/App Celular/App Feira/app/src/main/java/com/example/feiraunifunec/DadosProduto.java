package com.example.feiraunifunec;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.feiraunifunec.feiraretrofit.FeiraRetrofit;
import com.example.feiraunifunec.feiraretrofit.service.ProdutoService;
import com.example.feiraunifunec.feiraretrofit.service.TipoService;
import com.example.feiraunifunec.modelo.Produto;
import com.example.feiraunifunec.modelo.Tipo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DadosProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_produto);

        Button btnEditar = findViewById(R.id.btnEditarProduto);
        Button btnremover = findViewById(R.id.btnRemover);


        Intent it = getIntent();

        TextView txtcodigo = findViewById(R.id.txtCodigo);
        EditText edtNome = findViewById(R.id.edtnome);
        EditText edtquantidade = findViewById(R.id.edtQuantidade);
        EditText edtvalor = findViewById(R.id.edtValor);
        EditText edttipo = findViewById(R.id.edtTipo);


        Produto dadosEnviados = (Produto) it.getSerializableExtra("produto");
        txtcodigo.setText(dadosEnviados.getCodproduto().toString());
        edtNome.setText(dadosEnviados.getNomeproduto());
        edtquantidade.setText(dadosEnviados.getQuantidade()+"");
        edtvalor.setText(dadosEnviados.getValor()+"");
        //edttipo.setText(dadosEnviados.getTipo().getNometipo());


        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto teste = new Produto(Long.parseLong(txtcodigo.getText().toString()),
                        edtNome.getText().toString(),
                        Double.parseDouble(edtquantidade.getText().toString()),
                        Double.parseDouble(edtvalor.getText().toString()),
                        edttipo.getText().toString());

                long id = Long.parseLong(txtcodigo.getText().toString());
                atualizar(id, teste);
            }
        });

        btnremover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int aux = Integer.parseInt(txtcodigo.getText().toString());
                remover((long) aux);
            }
        });
    }

    private void remover(Long id)
    {
        TipoService service = new FeiraRetrofit().getTipoService();
        Call<Void> call = service.remove(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

    private void atualizar(Long id, Produto produto)
    {
        ProdutoService service = new FeiraRetrofit().getProdutoService();
        Call<Void> call = service.edita(id, produto);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

}