package com.jercorp.inscricao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jercorp.inscricao.model.Classe;
import com.jercorp.inscricao.repository.ClasseRepository;

@Service
public class ClasseService {
	@Autowired
	ClasseRepository classeRepository;
	
	public List<Classe> findAll(){
		List<Classe> classes = classeRepository.findAll();
		classes.sort((c1, c2) -> c1.getCodigo().compareTo(c2.getCodigo()));
		return classes;
	}
	
	public Optional<Classe> findByCodigo(Long codigo) {
		return classeRepository.findByCodigo(codigo);
	}
	
	public Optional<Classe> findByDescicaoAndCiclo(String descricao) {
		return classeRepository.findByDescricao(descricao);
	}
	
	public boolean exists(Classe classe) {
		if(classeRepository.findByDescricao(classe.getDescricao()).isPresent()) 
			return true;
		return false;
	}
	
	public Classe save(Classe classe) {
		classeRepository.save(classe);
		Classe classeSalva = classeRepository.findByDescricao(classe.getDescricao()).get();
		return classeSalva;
	}
	
	public Classe update(Classe classe) {
		if(classeRepository.exists(classe.getCodigo())) {
			classeRepository.saveAndFlush(classe);
		}
		return classe;
	}
	
	public Classe delete (Classe classe) {
		if(classeRepository.exists(classe.getCodigo())) {
			classeRepository.delete(classe);
		}
		return classe;
	}
	
	

}
