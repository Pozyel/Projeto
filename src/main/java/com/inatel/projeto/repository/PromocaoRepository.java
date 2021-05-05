package com.inatel.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.inatel.projeto.model.Promocao;


public interface PromocaoRepository extends JpaRepository<Promocao,Integer> {

	List<Promocao> findByGameName(String nome);
	

	

	

}
