package com.inatel.projeto.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.inatel.projeto.controller.dto.GameDto;
import com.inatel.projeto.controller.form.GameForm;
import com.inatel.projeto.model.Game;
import com.inatel.projeto.repository.GameRepository;

@RestController
@RequestMapping(path = "/games")
public class GameController {

	@Autowired
	private GameRepository gameRepository;

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDeJogos", allEntries = true)
	public ResponseEntity<GameDto> adicionarNovoGame(@RequestBody @Valid GameForm form,
			UriComponentsBuilder uriBuilder) {
		Game game = form.converter();
		boolean verifica = form.verificaGameExistente(gameRepository);

		if (verifica == true) {
			gameRepository.save(game);
			URI uri = uriBuilder.path("/games/{id}").buildAndExpand(game.getIdGame()).toUri();

			return ResponseEntity.created(uri).body(new GameDto(game));
		} else {
			return ResponseEntity.badRequest().build();
		}

	}

	@GetMapping
	@Cacheable(value = "listaDeJogos")
	public Page<GameDto> lista(@RequestParam(required = false) String name,
			@PageableDefault(sort = "Name", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (name == null) {
			Page<Game> games = gameRepository.findAll(paginacao);
			return GameDto.converter(games);
		} else {
			Page<Game> games = gameRepository.findByName(name, paginacao);
			return GameDto.converter(games);

		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<String> detalhar(@PathVariable Integer id) {

		Optional<Game> game = gameRepository.findById(id);
		RestTemplate restTemplate = new RestTemplate();
		String nomeGame = "Age Of Empires 2";
		String nomeBancoDeDados = game.get().getName();

		if (game.isPresent() && nomeBancoDeDados.equals(nomeGame)) {

			ResponseEntity<String> detalhe = restTemplate
					.getForEntity("https://age-of-empires-2-api.herokuapp.com/api/v1/civilizations", String.class);
			return detalhe;
		} else {

			return ResponseEntity.notFound().build();
		}

	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeJogos", allEntries = true)
	@ResponseBody
	public ResponseEntity<GameDto> atualizar(@PathVariable Integer id, @RequestBody @Valid GameForm form) {

		Optional<Game> optional = gameRepository.findById(id);

		if (optional.isPresent()) {
			Game game = form.atualizar(id, gameRepository);
			return ResponseEntity.ok(new GameDto(game));

		} else {

			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeJogos", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Integer id) {

		Optional<Game> optional = gameRepository.findById(id);

		if (optional.isPresent()) {
			gameRepository.deleteById(id);
			return ResponseEntity.ok().build();

		} else {

			return ResponseEntity.notFound().build();
		}

	}

}
