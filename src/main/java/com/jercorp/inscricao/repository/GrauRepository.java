package com.jercorp.inscricao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jercorp.inscricao.model.Grau;

public interface GrauRepository extends JpaRepository<Grau, Long>{
	public Optional <Grau> findByDescricao(String descricao);
	public Optional <Grau> findByCodigo(Long codigo);
}
