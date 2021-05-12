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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
class PromocaoControllerTest {


	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testarCadastroPromocao() throws Exception {
		URI uri = new URI("/promocoes");
		String json = "{\"idGame\":\"23\",\"precoPromocao\":\"10.0\"}";
		
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
	public void testarAtualizarPromocao() throws Exception {
		URI uri = new URI("/promocoes/19");
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
	public void testarDeletarPromocao() throws Exception {
		URI uri = new URI("/promocoes/48");
		
		mockMvc.perform(delete(uri))
        .andExpect(status().isOk());
				
	}
	
	@Test
	public void testarListarPromocao() throws Exception {
		URI uri = new URI("/promocoes");
		
		mockMvc.perform(get(uri))
        .andExpect(status().isOk());
				
	}
	
}
