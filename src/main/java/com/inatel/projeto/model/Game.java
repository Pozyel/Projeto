package com.inatel.projeto.model;





import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;





@Entity(name="game")
public class Game {
	

	public Game() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idGame;
	private String name;
	private Double price;
	@ManyToOne
	private Promocao promocao;
	@ManyToOne
	private Biblioteca biblioteca;
	
	
	
	public Promocao getPromocao() {
		return promocao;
	}
	public void setPromocao(Promocao promocao) {
		this.promocao = promocao;
	}
	public Biblioteca getBiblioteca() {
		return biblioteca;
	}
	public void setBiblioteca(Biblioteca biblioteca) {
		this.biblioteca = biblioteca;
	}
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
		this.name = name;
		this.price = price;
	}
	
	
	
	
}
