package com.inatel.projeto.controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inatel.projeto.controller.dto.GameDto;
import com.inatel.projeto.model.Game;
import com.inatel.projeto.repository.GameRepository;

@RestController
@RequestMapping(path="/games")
public class GameController {

	@Autowired
	private GameRepository gamerepository;
	
	@PostMapping
	public  String adicionarNovoGame(@RequestParam String name, @RequestParam Double price) {
		Game game = new Game();
		game.setName(name);
		game.setPrice(price);
		gamerepository.save(game);
		return"Salvo";
		
		
		}
	@GetMapping(path="/all")
	public List<GameDto> lista(String name){
		if (name == null) {
			List<Game> games =  gamerepository.findAll();
			return GameDto.converter(games);
		}else {
			List<Game> games =  gamerepository.findByName(name);
			return GameDto.converter(games);
			
		}
		
		
		
	}
}
