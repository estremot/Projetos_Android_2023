package com.unifunec.aluno.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codcurso;
	
	@Column
	private String nomecurso;

	public Long getCodcurso() {
		return codcurso;
	}

	public void setCodcurso(Long codcurso) {
		this.codcurso = codcurso;
	}

	public String getNomecurso() {
		return nomecurso;
	}

	public void setNomecurso(String nomecurso) {
		this.nomecurso = nomecurso;
	}
	
	

}
