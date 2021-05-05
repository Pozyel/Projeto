package com.inatel.projeto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.inatel.projeto.model.Biblioteca;


public class BibliotecaDto {

	private String nomeGame;
	private String nomeUsuario;


	
	
	public BibliotecaDto(Biblioteca biblioteca) {
		
		this.nomeGame = biblioteca.getGame().getName();
		this.nomeUsuario = biblioteca.getUsuario().getNome();
	}

	public String getNomeGame() {
		return nomeGame;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
public static List<BibliotecaDto> converter(List<Biblioteca> biblioteca) {
		
		return biblioteca.stream().map(BibliotecaDto::new).collect(Collectors.toList());
	}
}
