package com.unifunec.aluno.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unifunec")
public class C_Exemplo {
	
	@GetMapping
	public String teste() {
		return "Bem Vindo à UNIFUNEC 2023";
	}
	
	@PostMapping
	public String teste2() {
		return "Método Post";
	}

}
