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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.inatel.projeto.controller.dto.PromocaoDto;
import com.inatel.projeto.controller.form.AtualizaPromocaoForm;
import com.inatel.projeto.controller.form.PromocaoForm;
import com.inatel.projeto.model.Promocao;
import com.inatel.projeto.repository.GameRepository;
import com.inatel.projeto.repository.PromocaoRepository;

@RestController
@RequestMapping(path = "/promocoes")
public class PromocaoController {

	@Autowired
	private PromocaoRepository promocaoRepository;
	@Autowired
	private GameRepository gamerepository;

	@PostMapping
	@Transactional
	@CacheEvict(value = "listaDePromocoes", allEntries = true)
	public ResponseEntity<PromocaoDto> adicionarPromocoes(@RequestBody @Valid PromocaoForm form,
			UriComponentsBuilder uriBuilder) {
		Promocao promocao = form.converter(gamerepository);
		boolean verificaPromocao = form.verificaGamePromocao(promocaoRepository);
		if (verificaPromocao == true) {
			promocaoRepository.save(promocao);

			URI uri = uriBuilder.path("/promocoes/{id}").buildAndExpand(promocao.getIdSale()).toUri();
			return ResponseEntity.created(uri).body(new PromocaoDto(promocao));
		}

		return ResponseEntity.badRequest().build();

	}

	@GetMapping
	@Cacheable(value = "listaDePromocoes")
	public Page<PromocaoDto> lista(@RequestParam(required = false) String nome,
			@PageableDefault(sort = "GameName", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		if (nome == null) {
			Page<Promocao> promocoes = promocaoRepository.findAll(paginacao);
			return PromocaoDto.converter(promocoes);
		} else {
			Page<Promocao> promocoes = promocaoRepository.findByGameName(nome, paginacao);
			return PromocaoDto.converter(promocoes);

		}
	}

	@PutMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePromocoes", allEntries = true)
	public ResponseEntity<PromocaoDto> atualizar(@PathVariable Integer id,
			@RequestBody @Valid AtualizaPromocaoForm form) {

		Optional<Promocao> optional = promocaoRepository.findById(id);

		if (optional.isPresent()) {

			Promocao promocao = form.atualizar(id, promocaoRepository);
			return ResponseEntity.ok(new PromocaoDto(promocao));

		} else {

			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDePromocoes", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Integer id) {

		Optional<Promocao> optional = promocaoRepository.findById(id);

		if (optional.isPresent()) {

			promocaoRepository.deleteById(id);
			return ResponseEntity.ok().build();

		} else {

			return ResponseEntity.notFound().build();
		}

	}
}
