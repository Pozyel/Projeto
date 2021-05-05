package com.inatel.projeto.controller.form;






import com.inatel.projeto.model.Game;
import com.inatel.projeto.model.Promocao;
import com.inatel.projeto.repository.GameRepository;




public class PromocaoForm {

	private Integer idGame;
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
		return new Promocao(game,precoPromocao);
	}

	
	
	
	
}
