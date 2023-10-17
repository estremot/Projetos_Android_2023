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

import com.estremote.Feira.model.Produto;
import com.estremote.Feira.model.Tipo;
import com.estremote.Feira.repository.ProdutoRepository;
import com.estremote.Feira.repository.TipoRepository;



@RestController
@RequestMapping("/feira/produtos")
public class C_Produto {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	
	@GetMapping
	public List<Produto> lista() //DTO - Data Transfer Object
	{
			List<Produto> produtos = produtoRepository.findAll();
			return produtos;
	}
		
	@PostMapping 
	@jakarta.transaction.Transactional
	public ResponseEntity<Produto> cadastrar(@RequestBody Produto form, UriComponentsBuilder uriBuilder) {
					
		Tipo tipo = tipoRepository.findByNometipo(form.getTipo().getNometipo());
		System.out.println("Tipo = "+tipo.getNometipo());
	
		Produto produto =  new Produto(form, tipo);  
	
		
		produtoRepository.save(produto);
		
		URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getCodproduto()).toUri();
		return ResponseEntity.created(uri).body(produto);
						
	}
	
	@GetMapping("/{id}")
	public Produto detalhar(@PathVariable Long id)
	{
		
		Produto produto = produtoRepository.getOne(id);
		
		return produto;
		
	}
	
	@PutMapping("/{id}")
	@jakarta.transaction.Transactional
	public  ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto form){
		
		//Produto produto = form.atualizar(id, tipoRepository, produtoRepository);
		
		Tipo tipo = tipoRepository.findByNometipo(form.getTipo().getNometipo());
		
		Produto produto = produtoRepository.getOne(id);
		
		produto.setNomeproduto(form.getNomeproduto());
		produto.setQuantidade(form.getQuantidade());
		produto.setValor(form.getValor());
		produto.setTipo(tipo);
	
		//Produto produto = form;
		return ResponseEntity.ok(produto);
		
	}
	
	@DeleteMapping("/{id}")
	@jakarta.transaction.Transactional
	public  ResponseEntity<Produto> remover(@PathVariable Long id){
		produtoRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
}
