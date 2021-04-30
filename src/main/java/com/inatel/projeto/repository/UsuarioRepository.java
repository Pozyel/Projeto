package com.inatel.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import com.inatel.projeto.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Integer> {

}
