package com.jercorp.inscricao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jercorp.inscricao.factory.AlunoFactory;
import com.jercorp.inscricao.model.Aluno;
import com.jercorp.inscricao.model.Classe;
import com.jercorp.inscricao.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepository;
	@Autowired
	AlunoFactory alunoFactory; 
	
	public List<Aluno> findAll(){
		List<Aluno> alunos = alunoRepository.findAll(); 
		return alunos;
	}
	
	public Aluno findByCodigo(Long codigo) {
		Optional<Aluno> aluno = alunoRepository.findByCodigo(codigo);
		if(aluno.isPresent()) {
			return aluno.get();
		} else {
			return alunoFactory.alunoNull();
		}
	}
	
	public Aluno findByNomeAndClasse(String nome, Classe classe) {
		return alunoRepository.findByNomeAndClasse(nome, classe).get();
	}
	
	public boolean exist(String nome) {
		if (alunoRepository.findByNomeContaining(nome)!= null)
			return true; 
		return false;
	}
	
	public Aluno save(Aluno aluno) {
		Optional<Aluno> alunoExistente = alunoRepository.findByNomeAndClasse(aluno.getNome(), aluno.getClasse());
		if(alunoExistente.isPresent()) {
			return aluno;
		} else {
			return alunoRepository.save(aluno);
		}			
	}
	
	public void delete(Aluno aluno) {
		alunoRepository.delete(aluno);
	}

	public Aluno update(Aluno aluno) {
		if(alunoRepository.exists(aluno.getCodigo())) {
			alunoRepository.save(aluno);	
		}
		return alunoRepository.findOne(aluno.getCodigo());
	}

	public List<Aluno> findByNome(String nome) {
		return alunoRepository.findByNomeContaining(nome);
	}
}
