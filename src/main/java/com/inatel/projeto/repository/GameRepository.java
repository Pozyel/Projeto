package com.inatel.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.inatel.projeto.model.Game;


public interface GameRepository extends JpaRepository<Game,Integer> {

	List<Game> findByName(String name);
	Game findByIdGame(Integer id);
    


	

}
