package com.inatel.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Biblioteca {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_biblioteca;
	private Integer id_usuario;
	private Integer id_games;
	public Integer getIdUsuario() {
		return id_usuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.id_usuario = idUsuario;
	}
	public Integer getIdGames() {
		return id_games;
	}
	public void setIdGames(Integer idGames) {
		this.id_games = idGames;
	}
	public Integer getIdBiblioteca() {
		return id_biblioteca;
	}
	public void setIdBiblioteca(Integer idBiblioteca) {
		this.id_biblioteca = idBiblioteca;
	}
	
	
	
	
	
	
	
	
}
