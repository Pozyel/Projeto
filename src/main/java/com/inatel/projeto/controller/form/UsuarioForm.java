package com.inatel.projeto.controller.form;

import com.inatel.projeto.model.Usuario;
import com.inatel.projeto.repository.UsuarioRepository;
import com.sun.istack.NotNull;

public class UsuarioForm {

	@NotNull 
	private String nome;
	@NotNull
	private String email;
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
		
		return new Usuario(nome,senha,email);
	}
	public Usuario atualizar(Integer id, UsuarioRepository usuariorepository) {
		Usuario usuario = usuariorepository.getOne(id);
		usuario.setNome(this.nome);
		usuario.setEmail(this.email);
		usuario.setSenha(this.senha);
		return usuario;
	}
	
	
	
	
}
