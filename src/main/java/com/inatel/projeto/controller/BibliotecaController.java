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
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inatel.projeto.controller.dto.BibliotecaDto;
import com.inatel.projeto.controller.form.BibliotecaForm;
import com.inatel.projeto.model.Biblioteca;
import com.inatel.projeto.repository.BibliotecaRepository;
import com.inatel.projeto.repository.GameRepository;
import com.inatel.projeto.repository.UsuarioRepository;

@Component
@RestController
@RequestMapping(path = "/biblioteca")
public class BibliotecaController {

	@Autowired
	private BibliotecaRepository bibliotecaRepository;

	@Autowired
	private UsuarioRepository usuariorepository;

	@Autowired
	private GameRepository gamerepository;

	@PostMapping
	@CacheEvict(value = "listaDeBiblioteca", allEntries = true)
	public ResponseEntity<BibliotecaDto> adicionarJogosABiblioteca(@RequestBody @Valid BibliotecaForm form,
			UriComponentsBuilder uriBuilder) {
		Biblioteca biblioteca = form.converter(gamerepository, usuariorepository);

		URI uri = uriBuilder.path("/biblioteca/{id}").buildAndExpand(biblioteca.getId_biblioteca()).toUri();
		bibliotecaRepository.save(biblioteca);
		return ResponseEntity.created(uri).body(new BibliotecaDto(biblioteca));
	}

	@GetMapping
	@Cacheable(value = "listaDeBiblioteca")
	public Page<BibliotecaDto> ListarBiblioteca(@RequestParam String nomeUsuario,
			@PageableDefault(sort = "GameName", direction = Direction.ASC, page = 0, size = 10) Pageable paginacao) {

		Page<Biblioteca> biblioteca = bibliotecaRepository.findByUsuarioNome(nomeUsuario, paginacao);
		return BibliotecaDto.converter(biblioteca);

	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeBiblioteca", allEntries = true)
	public ResponseEntity<?> remover(@PathVariable Integer id) {

		Optional<Biblioteca> optional = bibliotecaRepository.findById(id);

		if (optional.isPresent()) {

			bibliotecaRepository.deleteById(id);
			return ResponseEntity.ok().build();

		} else {

			return ResponseEntity.notFound().build();
		}

	}

}
