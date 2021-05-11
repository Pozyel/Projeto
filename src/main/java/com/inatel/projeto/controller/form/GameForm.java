package com.inatel.projeto.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inatel.projeto.model.Game;
import com.inatel.projeto.repository.GameRepository;


public class GameForm {

	@NotEmpty
	@NotNull
	private String nomeGame;
	@NotNull
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

	public Game converter() {
		return new Game(nomeGame, precoGame);
	}

	public Game atualizar(Integer id, GameRepository gamerepository) {
		Game game = gamerepository.getOne(id);
		game.setName(this.nomeGame);
		game.setPrice(this.precoGame);

		return game;
	}


	public boolean verificaGameExistente(GameRepository gameRepository) {

		 Optional<String> nomeBancoDeDados = gameRepository.findByName(this.nomeGame);
		if ( nomeBancoDeDados.isPresent()) {
			return false;
		}

		
		return true;
	}
}
