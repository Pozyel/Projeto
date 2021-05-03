package com.inatel.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import com.inatel.projeto.model.Game;


public interface GameRepository extends CrudRepository<Game,Integer> {

}
