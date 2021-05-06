package com.inatel.projeto.controller.form;

import com.inatel.projeto.model.Promocao;
import com.inatel.projeto.repository.PromocaoRepository;

public class AtualizaPromocaoForm {

	private Double precoPromocao;

	public Double getPrecoPromocao() {
		return precoPromocao;
	}

	public void setPrecoPromocao(Double precoPromocao) {
		this.precoPromocao = precoPromocao;
	}

	public Promocao atualizar(Integer id, PromocaoRepository promocaorepository) {
		Promocao promocao = promocaorepository.getOne(id);
		promocao.setNew_price(this.precoPromocao);
		return promocao;
	}
	
	
}
