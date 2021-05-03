package com.inatel.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.inatel.projeto.model.Biblioteca;
import com.inatel.projeto.repository.BibliotecaRepository;

@Controller
@RequestMapping(path="/biblioteca")
public class BibliotecaController {

	@Autowired
	private BibliotecaRepository bibliotecarepository;
	
	@PostMapping(path="adicionar")
	public @ResponseBody String adicionarBilbiotecas(@RequestParam Integer id_usuario, @RequestParam Integer id_game) {
		Biblioteca biblioteca = new Biblioteca();
		biblioteca.setIdUsuario(id_usuario);
		biblioteca.setIdGames(id_game);
		bibliotecarepository.save(biblioteca);
		return"Salvo";
}
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Biblioteca> getAllUsers(){
		
		return bibliotecarepository.findAll();
	}
}
