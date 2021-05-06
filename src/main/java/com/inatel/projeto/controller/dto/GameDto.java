package com.inatel.projeto.controller.dto;



import org.springframework.data.domain.Page;

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



	
	public static Page<GameDto> converter(Page<Game> games) {
		
		return games.map(GameDto::new);
	}

}
