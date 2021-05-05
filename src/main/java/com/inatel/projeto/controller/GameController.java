package com.inatel.projeto.controller;





import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inatel.projeto.controller.dto.GameDto;
import com.inatel.projeto.controller.form.GameForm;
import com.inatel.projeto.model.Game;
import com.inatel.projeto.repository.GameRepository;
import com.inatel.projeto.repository.PromocaoRepository;

@RestController
@RequestMapping(path="/games")
public class GameController {

	@Autowired
	private GameRepository gamerepository;
	
	@Autowired
	private PromocaoRepository promocaorepository;
	
	
	@PostMapping
	public  ResponseEntity<GameDto> adicionarNovoGame(@RequestBody GameForm form,  UriComponentsBuilder uriBuilder) {
		Game game = form.converter();
		gamerepository.save(game);
		URI uri = uriBuilder.path("/games/{id}").buildAndExpand(game.getIdGame()).toUri();
		
		return ResponseEntity.created(uri).body(new GameDto(game));
		
		
		}
	@GetMapping
	public List<GameDto> lista(String name){
		if (name == null) {
			List<Game> games =  gamerepository.findAll();
			return GameDto.converter(games);
		}else {
			List<Game> games =  gamerepository.findByName(name);
			return GameDto.converter(games);
			
		}
		
		
		}
	
	
	@GetMapping("/{id}")
    public GameDto detalhar( @PathVariable Integer id) {
	
		Game game = gamerepository.getOne(id);
	
		
		return new GameDto(game);


}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<GameDto> atualizar(@PathVariable Integer id,@RequestBody GameForm form){
		Game game = form.atualizar(id,gamerepository);
		return ResponseEntity.ok(new GameDto(game));
		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id){
		gamerepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	
	}

