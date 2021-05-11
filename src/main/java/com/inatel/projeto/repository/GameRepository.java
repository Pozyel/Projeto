package com.inatel.projeto.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.projeto.model.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

	Page<Game> findByName(String name, Pageable paginacao);

	Game findByIdGame(Integer id);
	
	Optional<String> findByName(String name);

}
