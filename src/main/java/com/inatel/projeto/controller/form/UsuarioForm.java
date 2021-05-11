package com.inatel.projeto.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.inatel.projeto.model.Usuario;
import com.inatel.projeto.repository.UsuarioRepository;


public class UsuarioForm {

	@NotEmpty
	@NotNull
	private String nome;
	@NotEmpty
	@NotNull
	private String email;
	@NotEmpty
	@NotNull
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario converter() {

		return new Usuario(nome, senha, email);
	}

	public Usuario atualizar(Integer id, UsuarioRepository usuariorepository) {
		Usuario usuario = usuariorepository.getOne(id);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		return usuario;
	}

	public boolean verificaUsuarioExiste(UsuarioRepository usuarioRepository) {
		Optional<String> nomeBancoDeDados = usuarioRepository.findByNome(nome);
		
		if (nomeBancoDeDados.isPresent()) {
			return false;
		}
		
				return true;
	}

}
