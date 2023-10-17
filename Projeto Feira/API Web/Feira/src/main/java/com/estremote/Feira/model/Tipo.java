package com.estremote.Feira.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tipo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codtipo;
	
	@Column
	private String nometipo;
	
	@jakarta.persistence.OneToMany(mappedBy="tipo")
	private java.util.List<Produto> produtos; 
	
	public Tipo() {
		
	}
	public Long getCodtipo() {
		return codtipo;
	}
	public void setCodtipo(Long codtipo) {
		this.codtipo = codtipo;
	}
	public String getNometipo() {
		return nometipo;
	}
	public void setNometipo(String nometipo) {
		this.nometipo = nometipo;
	}
	
	
}
