package com.example.feiraunifunec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.feiraunifunec.feiraretrofit.FeiraRetrofit;
import com.example.feiraunifunec.feiraretrofit.service.TipoService;
import com.example.feiraunifunec.modelo.Tipo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DadosTipo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_tipo);

        Button btnEditar = findViewById(R.id.btnEditarProduto);
        Button btnremover = findViewById(R.id.btnRemover);


        Intent it = getIntent();

        TextView txtcodigo = findViewById(R.id.txtCodigo);
        EditText edtNome = findViewById(R.id.edtnome);

        Tipo dadosEnviados = (Tipo) it.getSerializableExtra("aluno");
        txtcodigo.setText(dadosEnviados.getCodtipo().toString());
        edtNome.setText(dadosEnviados.getNometipo());


        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tipo teste = new Tipo(Long.parseLong(txtcodigo.getText().toString()),
                        edtNome.getText().toString());

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

    private void atualizar(Long id, Tipo tipo)
    {
        TipoService service = new FeiraRetrofit().getTipoService();
        Call<Void> call = service.edita(id, tipo);

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