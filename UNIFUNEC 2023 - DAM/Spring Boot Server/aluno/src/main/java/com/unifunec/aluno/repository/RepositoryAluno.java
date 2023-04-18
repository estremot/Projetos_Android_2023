package com.unifunec.aluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unifunec.aluno.modelo.Aluno;

public interface RepositoryAluno extends JpaRepository<Aluno, Long>{

}
