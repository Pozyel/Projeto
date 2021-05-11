package com.inatel.projeto.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.inatel.projeto.model.Promocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {

	Page<Promocao> findByGameName(String nome, Pageable paginacao);

	Optional<Integer> findByGameIdGame(Integer id);

}
