package com.example.feiraunifunec.modelo;

import java.io.Serializable;

public class Produto implements Serializable {

    private Long codproduto;
    private String nomeproduto;

    private  double valor;

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    private  double quantidade;

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    private Tipo tipo;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }



    public Produto(Long codproduto, String nomeproduto, double valor, double quantidade, String vtipo)
    {
        this.codproduto = codproduto;
        this.nomeproduto = nomeproduto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.tipo.setNometipo(vtipo);
    }


    public Long getCodproduto() {
        return codproduto;
    }

    public void setCodproduto(Long codproduto) {
        this.codproduto = codproduto;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }



    @Override public String toString() {
        return "Código: "+codproduto+" Nome: " + nomeproduto ;
    }

}



