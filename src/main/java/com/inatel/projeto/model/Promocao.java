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
	private String nomegame;
	private Integer idgame;
	private Double old_price;
	private Double new_price;
	
	
	public Promocao() {
	
	}
	

	public Promocao(String nomegame, Double old_price, Double new_price) {
		super();
		this.nomegame = nomegame;
		this.old_price = old_price;
		this.new_price = new_price;
	}


	public Promocao(Integer game_idgame,String nomegame, Double old_price, Double new_price) {
		this.idgame = game_idgame;
		this.nomegame = nomegame;
		this.old_price = old_price;
		this.new_price = new_price;
	}
	
	public String getNomegame() {
		return nomegame;
	}

	public void setNomegame(String nomegame) {
		this.nomegame = nomegame;
	}

	public Integer getIdSale() {
		return idSale;
	}
	public void setIdSale(Integer idSale) {
		this.idSale = idSale;
	}
	public Integer getidGame() {
		return idgame;
	}
	public void setidGame(Integer game_idGame) {
		idgame = game_idGame;
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
