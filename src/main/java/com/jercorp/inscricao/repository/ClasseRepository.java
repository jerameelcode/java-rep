package com.jercorp.inscricao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jercorp.inscricao.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{

	public Optional<Classe> findByCodigo(Long codigo);

	public Optional<Classe> findByDescricao(String descricao);

}
