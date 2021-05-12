package com.inatel.projeto.controller;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class UsuarioControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testarCadastroUsuario() throws Exception {
		URI uri = new URI("/usuarios");
		String json = "{\"email\":\"Teste@email.com\",\"nome\":\"Teste\",\"senha\":\"123456\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(201));
	}
	@Test
	public void testarAtualizarUsuario() throws Exception {
		URI uri = new URI("/usuarios/20");
		String json = "{\"email\":\"TesteAtualiza@email.com\",\"nome\":\"TesteAtualiza\",\"senha\":\"123456\"}";
		
		mockMvc
		.perform(MockMvcRequestBuilders
				.put(uri)
				.content(json)
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(200));
	}
	@Test
	public void testarDeletarUsuario() throws Exception {
		URI uri = new URI("/usuarios/45");
		
		mockMvc.perform(delete(uri))
        .andExpect(status().isOk());
				
	}

}
