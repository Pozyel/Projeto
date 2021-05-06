package com.inatel.projeto.controller.dto;

import com.inatel.projeto.model.Usuario;

public class UsuarioDto {

	private String nome;

	public String getNome() {
		return nome;
	}

	public UsuarioDto(Usuario usuario) {
		
		this.nome = usuario.getNome();
	}
	
	
}
