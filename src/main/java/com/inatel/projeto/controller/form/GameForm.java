package com.inatel.projeto.controller.form;

import com.inatel.projeto.model.Game;
import com.inatel.projeto.repository.GameRepository;
import com.sun.istack.NotNull;

public class GameForm {

	private String nomeGame;
	private Double precoGame;
	
	public String getNome() {
		return nomeGame;
	}
	public void setNome(String nome) {
		this.nomeGame = nome;
	}
	public Double getPrice() {
		return precoGame;
	}
	public void setPrice(Double price) {
		this.precoGame = price;
	}
	
	public Game converter () {
		return new Game(nomeGame,precoGame);
	}
	public Game atualizar(Integer id, GameRepository gamerepository) {
	    Game game = gamerepository.getOne(id);
	    game.setName(this.nomeGame);
	    game.setPrice(this.precoGame);
	    
		return game;
	}
}
