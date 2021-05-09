package com.inatel.projeto;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.inatel.projeto.controller.UsuarioController;

import com.inatel.projeto.repository.UsuarioRepository;




class UsuarioTest {
	private UsuarioController usuario;
	@Mock
	private UsuarioRepository repository;

	
	
	
	@BeforeEach
public void beforeEach() {
		MockitoAnnotations.initMocks(this);
	    this.usuario = new UsuarioController(repository);
	
	
	}
	
	

	@Test
	void testandoAdicaoDeUsuarios() {
	   
		
}
}