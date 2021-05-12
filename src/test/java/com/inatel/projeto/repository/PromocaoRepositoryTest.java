package com.inatel.projeto.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class PromocaoRepositoryTest {

	@Autowired
	private PromocaoRepository promocao;
	
	@Test
	public void deveriaCarregarONomeDoUsuario() {
		Integer id = 7;
		
		  Optional<Integer> recebido = promocao.findByGameIdGame(id);

		  Assert.assertNotNull(recebido.isPresent());;
}
}
