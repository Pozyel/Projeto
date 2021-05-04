package com.inatel.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.inatel.projeto.model.Usuario;
import com.inatel.projeto.repository.UsuarioRepository;

@RestController
@RequestMapping(path="/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuariorepository;
	@PostMapping(path="adicionar")
	public @ResponseBody String adicionarNovoUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String senha) {
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setSenha(senha);
		usuariorepository.save(usuario);
		return"Salvo";
	}
	

}
