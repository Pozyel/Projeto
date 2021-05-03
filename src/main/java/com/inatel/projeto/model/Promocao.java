package com.inatel.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Promocao {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idSale;
	
	private Integer game_idgame;
	private Double old_price;
	private Double new_price;
	public Integer getIdSale() {
		return idSale;
	}
	public void setIdSale(Integer idSale) {
		this.idSale = idSale;
	}
	public Integer getGame_idGame() {
		return game_idgame;
	}
	public void setGame_idGame(Integer game_idGame) {
		game_idgame = game_idGame;
	}
	public Double getOld_price() {
		return old_price;
	}
	public void setOld_price(Double old_price) {
		this.old_price = old_price;
	}
	public Double getNew_price() {
		return new_price;
	}
	public void setNew_price(Double new_price) {
		this.new_price = new_price;
	}
	
}
