package com.example.feiraunifunec;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.feiraunifunec.feiraretrofit.FeiraRetrofit;
import com.example.feiraunifunec.feiraretrofit.service.ProdutoService;
import com.example.feiraunifunec.feiraretrofit.service.TipoService;
import com.example.feiraunifunec.modelo.Produto;
import com.example.feiraunifunec.modelo.Tipo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InserirDadosProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_produto);

        Button btnsalvar = findViewById(R.id.btnSalvar2);
        EditText edtnome = findViewById(R.id.edtnome2);
        EditText edtquantidade = findViewById(R.id.edtquantidade);
        EditText edtvalor = findViewById(R.id.edtvalor);
        EditText edttipo = findViewById(R.id.edttipo);

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Produto teste = new Produto(null, edtnome.getText().toString(),
                        Double.parseDouble(edtquantidade.getText().toString()),
                        Double.parseDouble(edtvalor.getText().toString()),
                        edttipo.getText().toString());
                salvar(teste);
                Log.i("Salvei", "onClick: ");
            }
        });
    }


    private void salvar(Produto produto)
    {

        ProdutoService service = new FeiraRetrofit().getProdutoService();
        Call<Produto> call = service.salva(produto);

        call.enqueue(new Callback<Produto>() {
            @Override
            public void onResponse(Call<Produto> call, Response<Produto> response) {
                System.out.println("Sucesso");
            }

            @Override
            public void onFailure(Call<Produto> call, Throwable t) {
                System.out.print("Falha");
            }
        });
    }
}