package com.inatel.projeto.repository;



import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inatel.projeto.model.Game;


@RunWith(SpringRunner.class)
@SpringBootTest
class GameRepositoryTest {

	@Autowired
	private GameRepository game;

	@Test
	public void deveriaCarregarUmJogoAoBuscarPeloId() {
		Integer id = 3;
		
		 Game recebido = game.findByIdGame(id);

		  Assert.assertEquals(recebido.getIdGame(), id);
}
	@Test
	public void deveriaCarregarONomeDoJogo() {
		String nome = "Dark Souls";
		
		  Optional<String> recebido = game.findByName(nome);

		  Assert.assertNotNull(recebido.isPresent());;
}
}
