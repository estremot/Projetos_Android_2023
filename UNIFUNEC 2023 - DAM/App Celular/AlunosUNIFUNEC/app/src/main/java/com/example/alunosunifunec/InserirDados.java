package com.example.alunosunifunec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.alunosunifunec.alunoretrofit.AlunoRetrofit;
import com.example.alunosunifunec.alunoretrofit.service.AlunoService;
import com.example.alunosunifunec.modelo.Alunos;

import java.io.ByteArrayOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InserirDados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_dados);

        Button btnsalvar = findViewById(R.id.btnSalvar2);
        EditText edtnome = findViewById(R.id.edtnome2);
        EditText edtcurso = findViewById(R.id.edtcurso2);

        btnsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alunos teste = new Alunos(null, edtnome.getText().toString(), edtcurso.getText().toString());
                salvar(teste);
                Log.i("Salvei", "onClick: ");
            }
        });
    }


    private void salvar(Alunos amigo)
    {

        AlunoService service = new AlunoRetrofit().getAlunoService();
        Call<Alunos> call = service.salva(amigo);

        call.enqueue(new Callback<Alunos>() {
            @Override
            public void onResponse(Call<Alunos> call, Response<Alunos> response) {
                System.out.println("Sucesso");
            }

            @Override
            public void onFailure(Call<Alunos> call, Throwable t) {
                System.out.print("Falha");
            }
        });
    }
}