package com.unifunec.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifunec.aluno.Modelo.Curso;

public interface RepositoryCurso extends JpaRepository<Curso, Long>{

}
