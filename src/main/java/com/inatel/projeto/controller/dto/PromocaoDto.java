package com.inatel.projeto.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

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

	public static List<PromocaoDto> converter(List<Promocao> promocoes) {
		
		return promocoes.stream().map(PromocaoDto::new).collect(Collectors.toList());
	}
	
	
	
	
	
	
}
