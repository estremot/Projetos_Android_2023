package com.estremote.Feira.controller;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.estremote.Feira.model.Tipo;
import com.estremote.Feira.repository.TipoRepository;

@RestController
@RequestMapping("/feira/tipos")
public class C_Tipo {
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@GetMapping
	public List<Tipo> lista() //DTO - Data Transfer Object
	{
			List<Tipo> tipos = tipoRepository.findAll();
			return tipos;
	}
		
	@PostMapping
	@jakarta.transaction.Transactional
	public ResponseEntity<Tipo> cadastrar(@RequestBody  Tipo form, UriComponentsBuilder uriBuilder) {
		
		Tipo tipo =  form;
		tipoRepository.save(tipo);
		

		URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(tipo.getCodtipo()).toUri();
		return ResponseEntity.created(uri).body(tipo);
						
	}
	
	@GetMapping("/{id}")
	public Tipo detalhar(@PathVariable Long id)
	{
		
		Tipo tipo = tipoRepository.getOne(id);
		
		return tipo;
		
	}
	
	@PutMapping("/{id}")
	@jakarta.transaction.Transactional
	public  ResponseEntity<Tipo> atualizar(@PathVariable Long id, @RequestBody Tipo tipo){
		
		 tipo.setCodtipo(id);
		 tipoRepository.save(tipo);
		
		return ResponseEntity.ok().body(tipo);
		
	}
	
	@DeleteMapping("/{id}")
	@jakarta.transaction.Transactional
	public  ResponseEntity<Tipo> remover(@PathVariable Long id){
		tipoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

}
