package com.inatel.projeto.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.inatel.projeto.controller.dto.UsuarioDto;
import com.inatel.projeto.controller.form.UsuarioForm;
import com.inatel.projeto.model.Usuario;
import com.inatel.projeto.repository.UsuarioRepository;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {

	private UsuarioRepository usuarioRepository;
	

	@Autowired
	public UsuarioController(UsuarioRepository usuariorepository) {
		this.usuarioRepository = usuariorepository;
		
	}

	@PostMapping
	public ResponseEntity<UsuarioDto> adicionarNovoUsuario(@RequestBody @Valid UsuarioForm form,
			UriComponentsBuilder uriBuilder) {
		Usuario usuario = form.converter();
		boolean verificaUsuario = form.verificaUsuarioExiste(usuarioRepository);
		if (verificaUsuario == true) {
			URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
			usuarioRepository.save(usuario);
			return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
		}
		return ResponseEntity.badRequest().build();

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Integer id, @RequestBody @Valid UsuarioForm form) {

		Optional<Usuario> optional = usuarioRepository.findById(id);

		if (optional.isPresent()) {
			Usuario usuario = form.atualizar(id, usuarioRepository);
			return ResponseEntity.ok(new UsuarioDto(usuario));

		} else {

			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id) {

		Optional<Usuario> optional = usuarioRepository.findById(id);

		if (optional.isPresent()) {
			usuarioRepository.deleteById(id);
			return ResponseEntity.ok().build();

		} else {

			return ResponseEntity.notFound().build();
		}

	}
}
