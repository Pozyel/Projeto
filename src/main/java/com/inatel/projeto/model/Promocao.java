package com.inatel.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "promocao")
public class Promocao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idSale;
	private Double new_price;
	@ManyToOne
	private Game game;

	public Promocao() {
	}

	public Promocao(Game game, Double new_price) {
		this.game = game;
		this.new_price = new_price;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Integer getIdSale() {
		return idSale;
	}

	public void setIdSale(Integer idSale) {
		this.idSale = idSale;
	}

	public Double getNew_price() {
		return new_price;
	}

	public void setNew_price(Double new_price) {
		this.new_price = new_price;
	}

}
