package com.inatel.projeto.controller.form;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import com.inatel.projeto.model.Game;
import com.inatel.projeto.model.Promocao;
import com.inatel.projeto.repository.GameRepository;
import com.inatel.projeto.repository.PromocaoRepository;

public class PromocaoForm {

	@NotNull
	private Integer idGame;
	@NotNull
	private Double precoPromocao;

	public Integer getIdGame() {
		return idGame;
	}

	public void setIdGame(Integer idGame) {
		this.idGame = idGame;
	}

	public Double getPrecoPromocao() {
		return precoPromocao;
	}

	public void setPrecoPromocao(Double precoPromocao) {
		this.precoPromocao = precoPromocao;
	}

	public Promocao converter(GameRepository repository) {
		Game game = repository.findByIdGame(idGame);
		return new Promocao(game, precoPromocao);
	}

	public boolean verificaGamePromocao(PromocaoRepository promocaoRepository) {
		Optional<Integer> idGameBancoDeDados = promocaoRepository.findByGameIdGame(this.idGame);
		if (idGameBancoDeDados.isPresent()) {
			return false;
		}
		return true;
	}

}
