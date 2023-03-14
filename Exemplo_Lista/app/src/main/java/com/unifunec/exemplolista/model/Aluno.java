package com.unifunec.exemplolista.model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Aluno implements Serializable {

    private int id = 0;
    private final String nome;
    private final String telefone;
    private final String email;

    public Aluno(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @NonNull
    @Override
    public String toString() {
       return getNome();
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
