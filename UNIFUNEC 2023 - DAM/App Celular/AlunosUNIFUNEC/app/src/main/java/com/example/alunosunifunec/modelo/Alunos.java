package com.example.alunosunifunec.modelo;

import java.io.Serializable;

public class Alunos implements Serializable {

    private Long codaluno;
    private String nomealuno;
    private String curso;

    public Alunos(Long codaluno, String nomealuno, String curso)
    {
        this.codaluno = codaluno;
        this.nomealuno = nomealuno;
        this.curso = curso;
    }


    public Long getCodaluno() {
        return codaluno;
    }

    public void setCodaluno(Long codaluno) {
        this.codaluno = codaluno;
    }

    public String getNomealuno() {
        return nomealuno;
    }

    public void setNomealuno(String nomealuno) {
        this.nomealuno = nomealuno;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override public String toString() {
        return "Código: "+codaluno+" Nome: " + nomealuno + "\nCurso: " + curso ;
    }

}



