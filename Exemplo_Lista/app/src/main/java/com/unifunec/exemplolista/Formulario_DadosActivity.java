package com.unifunec.exemplolista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        setTitle("Cadastro de Alunos");
        AlunoDAO alunoDAO = new AlunoDAO();

        final EditText campoNome = findViewById(R.id.txt_nome);
        final EditText campoTelefone = findViewById(R.id.txt_Telefone);
        final EditText campoEmail = findViewById(R.id.txt_email);


        Button botaoSalvar = findViewById(R.id.btn_Salvar);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Aluno alunoCriado = criaAluno(campoNome, campoTelefone, campoEmail);
                salva(alunoCriado);

                //alunoDAO.edita();
            }

            private void salva(Aluno alunoCriado) {
                alunoDAO.salva(alunoCriado);

                finish(); //tem a mesma ação de chamar o Intent... aquie ele destrói a activity atual
            }
        });

        Intent dados = getIntent();
        Aluno aluno1 = (Aluno) dados.getSerializableExtra("aluno");

        if(aluno1 != null) {
            campoNome.setText(aluno1.getNome());
            campoTelefone.setText(aluno1.getTelefone());
            campoEmail.setText(aluno1.getEmail());
        }
    }

    @NonNull
    private Aluno criaAluno(EditText campoNome, EditText campoTelefone, EditText campoEmail) {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        Aluno alunoCriado = new Aluno(nome, telefone, email);
        return alunoCriado;
    }
}