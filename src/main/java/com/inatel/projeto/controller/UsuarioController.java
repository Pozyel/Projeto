package com.inatel.projeto.controller;

import java.net.URI;

import javax.transaction.Transactional;

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
@RequestMapping(path="/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuariorepository;
	@PostMapping
	public ResponseEntity<UsuarioDto> adicionarNovoUsuario(@RequestBody  UsuarioForm form,UriComponentsBuilder uriBuilder ) {
		Usuario usuario = form.converter();
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getIdUsuario()).toUri();
		usuariorepository.save(usuario);
		return ResponseEntity.created(uri).body(new UsuarioDto(usuario));
	}
	

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UsuarioDto> atualizar(@PathVariable Integer id,@RequestBody UsuarioForm form){
		Usuario usuario = form.atualizar(id,usuariorepository);
		return ResponseEntity.ok(new UsuarioDto(usuario));
		
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id){
		usuariorepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
