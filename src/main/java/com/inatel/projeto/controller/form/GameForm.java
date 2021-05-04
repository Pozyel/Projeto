package com.inatel.projeto.controller.form;

import com.inatel.projeto.model.Game;

public class GameForm {

	private String nome;
	private Double price;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Game converter () {
		return new Game(nome,price);
	}
}
