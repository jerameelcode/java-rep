package com.jercorp.inscricao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jercorp.inscricao.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

	public Optional<Curso> findByCodigo(Long codigo);

	public Optional<Curso> findByDescricao(String descricao);

}
