package com.example.alunosunifunec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alunosunifunec.alunoretrofit.AlunoRetrofit;
import com.example.alunosunifunec.alunoretrofit.service.AlunoService;
import com.example.alunosunifunec.modelo.Alunos;

import java.io.ByteArrayInputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DadosAluno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_aluno);

        Button btnEditar = findViewById(R.id.btnEditarAluno);
        Button btnremover = findViewById(R.id.btnRemover);


        Intent it = getIntent();

        TextView txtcodigo = findViewById(R.id.txtCodigo);
        EditText edtNome = findViewById(R.id.edtnome);
        EditText edtCurso = findViewById(R.id.edtcurso);

        Alunos dadosEnviados = (Alunos) it.getSerializableExtra("aluno");
        txtcodigo.setText(dadosEnviados.getCodaluno().toString());
        edtNome.setText(dadosEnviados.getNomealuno());
        edtCurso.setText(dadosEnviados.getCurso());

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alunos teste = new Alunos(Long.parseLong(txtcodigo.getText().toString()),
                        edtNome.getText().toString(),
                        edtCurso.getText().toString());

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
        AlunoService service = new AlunoRetrofit().getAlunoService();
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

    private void atualizar(Long id, Alunos amigos)
    {
        AlunoService service = new AlunoRetrofit().getAlunoService();
        Call<Void> call = service.edita(id, amigos);

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