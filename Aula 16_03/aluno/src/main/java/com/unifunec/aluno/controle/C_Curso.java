package com.unifunec.aluno.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifunec.aluno.Modelo.Curso;
import com.unifunec.aluno.repository.RepositoryCurso;

@RestController
@RequestMapping("/unifunec/cursos")
public class C_Curso {

	@Autowired
	private RepositoryCurso rc;
	
	@GetMapping
	public List<Curso> retCursos() {
		
		List<Curso> cursos =  rc.findAll();
		return cursos;
	}
	
	@GetMapping("/{id}")
	public String retCurdoId(@PathVariable Long id) {
		return "Pesquisar Curso pelo Id: "+id;
	}
}
