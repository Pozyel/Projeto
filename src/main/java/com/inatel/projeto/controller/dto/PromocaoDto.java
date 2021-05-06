package com.inatel.projeto.controller.dto;



import org.springframework.data.domain.Page;

import com.inatel.projeto.model.Promocao;

public class PromocaoDto {

	private String nome;
	private Double antigoPreco;
	private Double promocaoPreco;
	
	
	public PromocaoDto(Promocao promocao) {
		
		this.nome=promocao.getGame().getName();
		this.antigoPreco = promocao.getGame().getPrice();
		this.promocaoPreco = promocao.getNew_price();
		}

	
	
	public String getNome() {
		return nome;
	}



	public Double getAntigoPreco() {
		return antigoPreco;
	}

	public Double getPromocaoPreco() {
		return promocaoPreco;
	}

	public static Page<PromocaoDto> converter(Page<Promocao> promocoes) {
		
		return promocoes.map(PromocaoDto::new);
	}
	
	
	
	
	
	
}
