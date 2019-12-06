package com.jercorp.inscricao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jercorp.inscricao.model.Mensalidade;

@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Long>{

	public Optional<Mensalidade> findByCodigo(Long codigo);

	public Optional<Mensalidade> findByDescricao(String descricao);

}
