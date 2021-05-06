package com.inatel.projeto.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.inatel.projeto.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

	Usuario findByIdUsuario(Integer idUsuario);
	Optional <Usuario> findByEmail(String email);

}
