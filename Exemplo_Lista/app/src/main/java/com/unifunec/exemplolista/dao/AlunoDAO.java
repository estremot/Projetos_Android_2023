package com.unifunec.exemplolista.dao;

import com.unifunec.exemplolista.model.Aluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();
    private static  int contadorDeIds = 1;
    public void salva(Aluno aluno)
    {
        aluno.setId(contadorDeIds);
        alunos.add(aluno);
        contadorDeIds++;
    }

    public List<Aluno> todos() {

        return new ArrayList<>(alunos);
    }

    public void remove(Aluno aluno) {
        Aluno alunoDevolvido = buscaAlunoPeloId(aluno);
        if(alunoDevolvido != null) {
            alunos.remove(alunoDevolvido);
        }
    }

    public void edita(Aluno aluno){

    }

    private Aluno buscaAlunoPeloId(Aluno aluno) {
        Aluno alunoEncontrado = null;
        for(Aluno a : alunos){
            if(a.getId() == aluno.getId()){
                alunoEncontrado = a;
            }
        }
        if(alunoEncontrado != null){
            int posicaoDoAluno = alunos.indexOf(alunoEncontrado);
            alunos.set(posicaoDoAluno,aluno);
        }
        return alunoEncontrado;
    }
}
