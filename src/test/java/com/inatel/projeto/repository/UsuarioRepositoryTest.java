package com.inatel.projeto.repository;


import java.util.Optional;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.inatel.projeto.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuario;
	
	
	@Test
	public void deveriaCarregarUmUSuarioAoBuscarPeloId() {
		Integer id = 2;
		
		  Usuario recebido = usuario.findByIdUsuario(id);

		  Assert.assertEquals(recebido.getIdUsuario(), id);
}
	@Test
	public void deveriaCarregarOEmailDoUsuario() {
		String email = "second@email.com";
		
		  Optional<Usuario> recebido = usuario.findByEmail(email);

		  Assert.assertEquals(email, recebido.get().getEmail());;
}
	@Test
	public void deveriaCarregarONomeDoUsuario() {
		String nome = "Second";
		
		  Optional<String> recebido = usuario.findByNome(nome);

		  Assert.assertNotNull(recebido.isPresent());;
}
}