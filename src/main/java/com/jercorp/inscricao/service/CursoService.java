package com.jercorp.inscricao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jercorp.inscricao.model.Curso;
import com.jercorp.inscricao.repository.CursoRepository;

@Service
public class CursoService {
	@Autowired
	CursoRepository cursoRepository;
	
	public List<Curso> findAll(){
		List<Curso> cursos = cursoRepository.findAll();
		cursos.sort((c1, c2) -> c1.getCodigo().compareTo(c2.getCodigo()));
		return cursos;
	}
	
	public Optional<Curso> findByCodigo(Long codigo) {
		return cursoRepository.findByCodigo(codigo);
	}
	
	public Optional<Curso> findByDescicaoAndCiclo(String descricao) {
		return cursoRepository.findByDescricao(descricao);
	}
	
	public boolean exists(Curso curso) {
		if(cursoRepository.findByDescricao(curso.getDescricao()).isPresent()) 
			return true;
		return false;
	}
	
	public Curso save(Curso curso) {
		cursoRepository.save(curso);
		Curso cursoSalvo = cursoRepository.findByDescricao(curso.getDescricao()).get();
		return cursoSalvo;
	}
	
	public Curso update(Curso curso) {
		if(cursoRepository.exists(curso.getCodigo())) {
			cursoRepository.saveAndFlush(curso);
		}
		return curso;
	}
	
	public Curso delete (Curso curso) {
		if(cursoRepository.exists(curso.getCodigo())) {
			cursoRepository.delete(curso);
		}
		return curso;
	}
	
	

}
