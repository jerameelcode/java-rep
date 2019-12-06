package com.jercorp.inscricao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jercorp.inscricao.model.Aluno;
import com.jercorp.inscricao.model.Classe;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	public Optional<Aluno> findByNomeAndClasse(String nome, Classe classe);
	public List<Aluno> findByNomeContaining(String nome);
	public Optional<Aluno> findByCodigo(Long codigo);
}
