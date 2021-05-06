package com.inatel.projeto.controller;

import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

@RestController
@RequestMapping(path="/biblioteca")
public class BibliotecaController {

	@Autowired
	private BibliotecaRepository bibliotecarepository;
	
	@Autowired
	private UsuarioRepository usuariorepository;
	
	@Autowired
	private GameRepository gamerepository;
	
	
	@PostMapping
	@CacheEvict(value="listaDeBiblioteca",allEntries = true)
	public ResponseEntity<BibliotecaDto> adicionarBilbiotecas(@RequestBody BibliotecaForm form,  UriComponentsBuilder uriBuilder) {
		Biblioteca biblioteca = form.converter(gamerepository,usuariorepository);
		
		URI uri = uriBuilder.path("/biblioteca/{id}").buildAndExpand(biblioteca.getId_biblioteca()).toUri();
		bibliotecarepository.save(biblioteca);
		return ResponseEntity.created(uri).body(new BibliotecaDto(biblioteca)) ;
}
	@GetMapping
	@Cacheable(value="listaDeBiblioteca")
	public Page<BibliotecaDto> ListarBiblioteca(@RequestParam String nomeUsuario,@PageableDefault(sort = "GameName",direction = Direction.ASC, page = 0, size = 10) Pageable paginacao){
		
	    	Page<Biblioteca>biblioteca = bibliotecarepository.findByUsuarioNome(nomeUsuario,paginacao);
			return BibliotecaDto.converter(biblioteca);
		
		
	}
}
