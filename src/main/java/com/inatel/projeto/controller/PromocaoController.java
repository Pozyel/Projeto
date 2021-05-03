package com.inatel.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.inatel.projeto.model.Promocao;
import com.inatel.projeto.repository.PromocaoRepository;

@Controller
@RequestMapping(path="/promocoes")
public class PromocaoController {

	@Autowired
	private PromocaoRepository promocaorepository;
	
	@PostMapping(path="adicionar")
	public @ResponseBody String adicionarPromocoes(@RequestParam Integer game_idgame,@RequestParam Double old_price, @RequestParam Double new_price) {
		Promocao promocao = new Promocao();
		promocao.setGame_idGame(game_idgame);
		promocao.setOld_price(old_price);
		promocao.setNew_price(new_price);
		promocaorepository.save(promocao);
		return"Salvo";
		
		
}
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Promocao> getAllUsers(){
		
		return promocaorepository.findAll();
	}
}
