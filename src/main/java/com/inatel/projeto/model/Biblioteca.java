package com.inatel.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "biblioteca")
public class Biblioteca {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_biblioteca;
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Game game;
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Usuario usuario;

	public Biblioteca() {
	}

	public Biblioteca(Game game, Usuario usuario) {
		this.game = game;
		this.usuario = usuario;

	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId_biblioteca() {
		return id_biblioteca;
	}

	public void setId_biblioteca(Integer id_biblioteca) {
		this.id_biblioteca = id_biblioteca;
	}

}
