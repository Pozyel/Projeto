package com.inatel.projeto.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inatel.projeto.model.Game;
import com.inatel.projeto.repository.GameRepository;

@Controller
@RequestMapping(path="/games")
public class GameController {

	@Autowired
	private GameRepository gamerepository;
	
	@PostMapping(path="adicionar")
	public @ResponseBody String adicionarNovoGame(@RequestParam String name, @RequestParam Double price) {
		Game game = new Game();
		game.setName(name);
		game.setPrice(price);
		gamerepository.save(game);
		return"Salvo";
		
		
		}
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Game> getAllUsers(){
		
		return gamerepository.findAll();
	}
}
