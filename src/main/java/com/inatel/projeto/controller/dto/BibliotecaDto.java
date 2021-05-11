package com.inatel.projeto.controller.dto;

import org.springframework.data.domain.Page;

import com.inatel.projeto.model.Biblioteca;

public class BibliotecaDto {

	private String nomeGame;

	public BibliotecaDto(Biblioteca biblioteca) {

		this.nomeGame = biblioteca.getGame().getName();
	}

	public String getNomeGame() {
		return nomeGame;
	}

	public static Page<BibliotecaDto> converter(Page<Biblioteca> biblioteca) {

		return biblioteca.map(BibliotecaDto::new);
	}
}
