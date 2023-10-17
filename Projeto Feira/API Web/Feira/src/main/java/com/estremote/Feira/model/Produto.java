package com.estremote.Feira.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codproduto;
	
	@Column
	private String nomeproduto;
	@Column
	private double valor;
	
	@Column
	private double quantidade;
	
	@jakarta.persistence.ManyToOne
	@jakarta.persistence.JoinColumn(name = "codtipo")
	private Tipo tipo;

	public Produto() {
		
	}
	public Produto(Produto p, Tipo tipo) {
		this.setNomeproduto(p.getNomeproduto());
		this.setQuantidade(p.getQuantidade());
		this.setValor(p.valor);
		this.setTipo(tipo);
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	} 
	
	
	
}
