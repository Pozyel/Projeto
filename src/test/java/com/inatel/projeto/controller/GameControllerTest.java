package com.inatel.projeto.controller;


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
class GameControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testarCadastroGame() throws Exception {
		URI uri = new URI("/games");
		String json = "{\"nome\":\"TesteGame\",\"price\":\"10.0\"}";
		
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
	public void testarAtualizarGame() throws Exception {
		URI uri = new URI("/games/19");
		String json = "{\"precoPromocao\":\"20\"}";
		
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
	public void testarDeletarGame() throws Exception {
		URI uri = new URI("/games/48");
		
		mockMvc.perform(delete(uri))
        .andExpect(status().isOk());
				
	}
	
	@Test
	public void testarListarGame() throws Exception {
		URI uri = new URI("/games");
		
		mockMvc.perform(get(uri))
        .andExpect(status().isOk());
				
	}
	@Test
	public void testarDetalharGame() throws Exception {
		URI uri = new URI("/games/7");
		
		mockMvc.perform(get(uri))
        .andExpect(status().isOk());
				
	}

}
