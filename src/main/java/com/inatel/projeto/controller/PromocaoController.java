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
import com.inatel.projeto.controller.dto.PromocaoDto;
import com.inatel.projeto.controller.form.AtualizaPromocaoForm;
import com.inatel.projeto.controller.form.PromocaoForm;
import com.inatel.projeto.model.Promocao;
import com.inatel.projeto.repository.GameRepository;
import com.inatel.projeto.repository.PromocaoRepository;

@RestController
@RequestMapping(path="/promocoes")
public class PromocaoController {

	@Autowired
	private PromocaoRepository promocaorepository;
	@Autowired
	private GameRepository gamerepository;
	
	
	
	@PostMapping
	public ResponseEntity<PromocaoDto> adicionarPromocoes( @RequestBody PromocaoForm form, UriComponentsBuilder uriBuilder) {
		Promocao promocao = form.converter(gamerepository);
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
			List<Promocao> promocoes =  promocaorepository.findByGameName(nome);
			return PromocaoDto.converter(promocoes);
			
		}
}
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PromocaoDto> atualizar(@PathVariable Integer id,@RequestBody AtualizaPromocaoForm form){
		Promocao promocao = form.atualizar(id,promocaorepository);
		return ResponseEntity.ok(new PromocaoDto(promocao));
		
	}
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Integer id){
		promocaorepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
