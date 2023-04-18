package com.unifunec.aluno.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.unifunec.aluno.modelo.Aluno;
import com.unifunec.aluno.repository.RepositoryAluno;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/unifunec/alunos")
public class C_Aluno {
	
	@Autowired
	private RepositoryAluno ra;
	
	@GetMapping
	public List<Aluno> retornaAlunos() {
		List<Aluno> la = ra.findAll();
		return la;
	}
	
	@GetMapping("/{id}")
	public Aluno retornaAlunoId(@PathVariable Long id) {
		Aluno a = ra.getOne(id);
		return a;
	}
	
	@DeleteMapping("{id}")
	public String deletaId(@PathVariable Long id) {
		
		ra.deleteById(id);
		return "Campo deletado com id = "+id;
	}
	
	@PostMapping()
	public String salvarDados(@RequestBody Aluno aluno) {
		
		ra.save(aluno);
		return "Dados do Aluno salvos com sucesso!!";
	}
	
	@PutMapping("/{id}")
	@Transactional
	public String atualizaDados(@PathVariable Long id, @RequestBody Aluno aluno) {
		
		 aluno.setCodaluno(id);
		 ra.save(aluno);

		return "Dados Atualizados";
	}
	

}
