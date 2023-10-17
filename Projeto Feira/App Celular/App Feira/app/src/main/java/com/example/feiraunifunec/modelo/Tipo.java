package com.example.feiraunifunec.modelo;

import java.io.Serializable;

public class Tipo implements Serializable {

    private Long codtipo;
    private String nometipo;

    public Tipo(Long codtipo, String nometipo)
    {
        this.codtipo = codtipo;
        this.nometipo = nometipo;
    }


    public Long getCodtipo() {
        return codtipo;
    }

    public void setCodtipo(Long codaluno) {
        this.codtipo = codtipo;
    }

    public String getNometipo() {
        return nometipo;
    }

    public void setNometipo(String nometipo) {
        this.nometipo = nometipo;
    }



    @Override public String toString() {
        return "Código: "+codtipo+" Nome: " + nometipo ;
    }

}



