package com.inatel.projeto.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
class BibliotecaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testarCadastroGame() throws Exception {
		URI uri = new URI("/biblioteca");
		String json = "{\"idGame\":\"6\",\"idUsuario\":\"2\"}";
		
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
	public void testarDeletarGame() throws Exception {
		URI uri = new URI("/biblioteca/50");
		
		mockMvc.perform(delete(uri))
        .andExpect(status().isOk());
				
	}
	
	@Test
	public void testarListarGame() throws Exception {
		URI uri = new URI("/biblioteca?nomeUsuario=Second");
		
		mockMvc.perform(get(uri))
        .andExpect(status().isOk());
				
	}

}
