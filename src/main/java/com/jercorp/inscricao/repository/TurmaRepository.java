package com.jercorp.inscricao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jercorp.inscricao.model.Classe;
import com.jercorp.inscricao.model.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	public Optional<Turma> findByDescricao(String descricao);
	public Optional<Turma> findByCodigo(Long codigo);
	public Optional<Turma> findByClasse(Classe classe);
	public List<Turma> findByDescricaoContaining(String descricao);
}
