package com.example.feiraunifunec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.feiraunifunec.R;
import com.example.feiraunifunec.feiraretrofit.FeiraRetrofit;
import com.example.feiraunifunec.feiraretrofit.service.TipoService;
import com.example.feiraunifunec.modelo.Tipo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InserirDadosTipo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_dados);

        Button btnsalvar = findViewById(R.id.btnSalvar2);
        EditText edtnome = findViewById(R.id.edtnome2);
       // EditText edtcurso = findViewById(R.id.edtcurso2);

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tipo teste = new Tipo(null, edtnome.getText().toString());
                salvar(teste);
                Log.i("Salvei", "onClick: ");
            }
        });
    }


    private void salvar(Tipo tipo)
    {

        TipoService service = new FeiraRetrofit().getTipoService();
        Call<Tipo> call = service.salva(tipo);

        call.enqueue(new Callback<Tipo>() {
            @Override
            public void onResponse(Call<Tipo> call, Response<Tipo> response) {
                System.out.println("Sucesso");
            }

            @Override
            public void onFailure(Call<Tipo> call, Throwable t) {
                System.out.print("Falha");
            }
        });
    }
}