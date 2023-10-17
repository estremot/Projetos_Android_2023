package com.estremote.Feira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estremote.Feira.model.Tipo;


public interface TipoRepository extends JpaRepository<Tipo, Long> {
	
	
	Tipo findByNometipo(String nometipo);
	//Tipo findByCodtipo(Long codtipo);
}
