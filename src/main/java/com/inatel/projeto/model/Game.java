package com.inatel.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {
	

	public Game() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idGame;
	private String name;
	private Double price;
	public Integer getIdGame() {
		return idGame;
	}
	public void setIdGame(Integer idGame) {
		this.idGame = idGame;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Game(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	
	
}
