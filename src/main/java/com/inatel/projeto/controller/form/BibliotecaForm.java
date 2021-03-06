package com.inatel.projeto.controller.form;

import javax.validation.constraints.NotNull;

import com.inatel.projeto.model.Biblioteca;
import com.inatel.projeto.model.Game;
import com.inatel.projeto.model.Usuario;
import com.inatel.projeto.repository.GameRepository;
import com.inatel.projeto.repository.UsuarioRepository;

public class BibliotecaForm {
	@NotNull
	private Integer idGame;

	@NotNull
	private Integer idUsuario;

	public Integer getIdGame() {
		return idGame;
	}

	public void setIdGame(Integer idGame) {
		this.idGame = idGame;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Biblioteca converter(GameRepository gamerepository, UsuarioRepository usuariorepository) {
		Game game = gamerepository.findByIdGame(this.idGame);
		Usuario usuario = usuariorepository.findByIdUsuario(this.idUsuario);

		return new Biblioteca(game, usuario);
	}

}
