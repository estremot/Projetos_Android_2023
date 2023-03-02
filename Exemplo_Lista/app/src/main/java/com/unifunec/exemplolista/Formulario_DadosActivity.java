package com.unifunec.exemplolista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unifunec.exemplolista.dao.AlunoDAO;
import com.unifunec.exemplolista.model.Aluno;

public class Formulario_DadosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_dados);

        AlunoDAO alunoDAO = new AlunoDAO();
        final EditText campoNome = findViewById(R.id.txt_nome);
        final EditText campoTelefone = findViewById(R.id.txt_Telefone);
        final EditText campoEmail = findViewById(R.id.txt_email);


        Button botaoSalvar = findViewById(R.id.btn_Salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = campoNome.getText().toString();
                String telefone = campoTelefone.getText().toString();
                String email = campoEmail.getText().toString();

               Aluno alunoCriado = new Aluno(nome, telefone, email);
                //Toast.makeText(Formulario_DadosActivity.this,alunoCriado.getNome() + " - " +
                //        alunoCriado.getTelefone() + " - " + alunoCriado.getEmail(),Toast.LENGTH_LONG).show();

                alunoDAO.salva(alunoCriado);
            }
        });
    }
}