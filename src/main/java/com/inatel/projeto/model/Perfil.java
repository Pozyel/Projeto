package com.inatel.projeto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Perfil implements GrantedAuthority {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idUsuario;
	
	private String autoridade;

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getAutoridade() {
		return autoridade;
	}

	public void setAutoridade(String autoridade) {
		this.autoridade = autoridade;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.autoridade;
	}
	
	
}
