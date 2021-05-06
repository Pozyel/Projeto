package com.inatel.projeto.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import com.inatel.projeto.model.Biblioteca;


public interface BibliotecaRepository extends JpaRepository<Biblioteca,Integer> {

	Page<Biblioteca> findByUsuarioNome(String nomeUsuario,Pageable paginacao);

}
