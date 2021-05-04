package com.inatel.projeto.controller.form;




import com.inatel.projeto.model.Promocao;



public class PromocaoForm {

	private Integer idGame;
	private String nomeGame;
	private Double precoGame;
	private Double precoPromocao;
	public Integer getIdGame() {
		return idGame;
	}
	public void setIdGame(Integer idGame) {
		this.idGame = idGame;
	}
	public Double getPrecoGame() {
		return precoGame;
	}
	public void setPrecoGame(Double precoGame) {
		this.precoGame = precoGame;
	}
	public Double getPrecoPromocao() {
		return precoPromocao;
	}
	public void setPrecoPromocao(Double precoPromocao) {
		this.precoPromocao = precoPromocao;
	}
	
	public String getNomeGame() {
		return nomeGame;
	}
	public void setNomeGame(String nomeGame) {
		this.nomeGame = nomeGame;
	}
	public Promocao converter() {
		
		return new Promocao(idGame,nomeGame,precoGame,precoPromocao);
	}
	
	
	
	
}
