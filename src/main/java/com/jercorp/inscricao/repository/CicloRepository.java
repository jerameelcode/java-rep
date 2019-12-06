package com.jercorp.inscricao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jercorp.inscricao.model.Ciclo;

@Repository
public interface CicloRepository extends JpaRepository<Ciclo, Long>{
	public Optional<Ciclo> findByDescricao(String descricao);

	public Optional<Ciclo> findByCodigo(Long codigo);


}
