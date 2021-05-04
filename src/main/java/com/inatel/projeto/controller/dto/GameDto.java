package com.inatel.projeto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.inatel.projeto.model.Game;

public class GameDto {
	private Integer id;
	private String nome;
	private Double price;
	
	
	

	public GameDto(Game game) {
		this.id = game.getIdGame();
		this.nome = game.getName();
		this.price = game.getPrice();
	}



	public Integer getId() {
		return id;
	}



	
	public String getNome() {
		return nome;
	}



	
	public Double getPrice() {
		return price;
	}



	
	public static List<GameDto> converter(List<Game> games) {
		
		return games.stream().map(GameDto::new).collect(Collectors.toList());
	}

}
