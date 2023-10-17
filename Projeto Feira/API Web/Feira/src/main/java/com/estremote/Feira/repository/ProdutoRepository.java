package com.estremote.Feira.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estremote.Feira.model.Produto;



public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	Produto findByNomeproduto(String nomeproduto);
}
