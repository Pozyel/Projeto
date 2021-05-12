package com.inatel.projeto.repository;



import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inatel.projeto.model.Biblioteca;


@RunWith(SpringRunner.class)
@SpringBootTest
class BibliotecaRepositoryTest {
	@Autowired
	private BibliotecaRepository biblioteca;

	@Test
	public void deveriaCarregarOEmailDoUsuario() {
		Integer id = 2;
		
		  Optional<Biblioteca> recebido = biblioteca.findByUsuarioIdUsuario(id);

		  Assert.assertNotNull(recebido.isPresent());;
}
}
