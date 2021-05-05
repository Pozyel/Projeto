package com.inatel.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.inatel.projeto.model.Biblioteca;


public interface BibliotecaRepository extends JpaRepository<Biblioteca,Integer> {

	List<Biblioteca> findByGameName(String nomeGame);

}
