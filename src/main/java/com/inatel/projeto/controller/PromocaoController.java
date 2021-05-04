package com.inatel.projeto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.inatel.projeto.controller.dto.PromocaoDto;
import com.inatel.projeto.controller.form.PromocaoForm;

import com.inatel.projeto.model.Promocao;
import com.inatel.projeto.repository.PromocaoRepository;

@RestController
@RequestMapping(path="/promocoes")
public class PromocaoController {

	@Autowired
	private PromocaoRepository promocaorepository;
	
	
	
	@PostMapping
	public ResponseEntity<PromocaoDto> adicionarPromocoes( @RequestBody PromocaoForm form, UriComponentsBuilder uriBuilder) {
		Promocao promocao = form.converter();
		promocaorepository.save(promocao);
		
		URI uri = uriBuilder.path("/promocoes/{id}").buildAndExpand(promocao.getIdSale()).toUri();
		return ResponseEntity.created(uri).body(new PromocaoDto(promocao));
		
		
		
}
	@GetMapping
	public List<PromocaoDto> lista(String nome){
		if (nome == null) {
			List<Promocao> promocoes =  promocaorepository.findAll();
			return PromocaoDto.converter(promocoes);
		}else {
			List<Promocao> promocoes =  promocaorepository.findByNomegame(nome);
			return PromocaoDto.converter(promocoes);
			
		}
}
}
