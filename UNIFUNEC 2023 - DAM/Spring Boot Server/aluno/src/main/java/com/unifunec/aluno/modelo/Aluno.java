package com.unifunec.aluno.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codaluno;
	
	@Column
	private String nomealuno;
	
	@Column
	private String curso;
	
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
	
	

}
