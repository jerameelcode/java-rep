package com.jercorp.inscricao.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jercorp.inscricao.model.Ciclo;
import com.jercorp.inscricao.model.Classe;
import com.jercorp.inscricao.model.Curso;
import com.jercorp.inscricao.model.Grau;
import com.jercorp.inscricao.model.Mensalidade;
import com.jercorp.inscricao.model.Sexo;
import com.jercorp.inscricao.model.Turma;
import com.jercorp.inscricao.repository.CicloRepository;
import com.jercorp.inscricao.repository.ClasseRepository;
import com.jercorp.inscricao.repository.CursoRepository;
import com.jercorp.inscricao.repository.GrauRepository;
import com.jercorp.inscricao.repository.MensalidadeRepository;
import com.jercorp.inscricao.repository.TurmaRepository;

@Service
public class UtilService {
	
	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	TurmaRepository turmaRepository;
	@Autowired
	ClasseRepository classeRepository;
	@Autowired
	CicloRepository cicloRepository;
	@Autowired
	GrauRepository grauRepository;
	@Autowired
	MensalidadeRepository mensalidadeRepository;
	
	
	public List<String> getCountries() {
		List<String> countries = new ArrayList<String>();
		
		Arrays.asList(Locale.getISOCountries()).forEach(c -> {
			Locale l = new Locale("", c);
			countries.add(l.getDisplayCountry());
			});
		return countries;
	}
	
	public List<Sexo> getSexos(){
		return Arrays.asList(Sexo.values());
	}
	
	public List<Curso> getCursos(){
		return cursoRepository.findAll();
	}
	public List<Ciclo> getCiclo(){
		return cicloRepository.findAll();
	}	
	public List<Mensalidade> getMensalidade(){
		return mensalidadeRepository.findAll();
	}
	public List<Turma> getTurma(){
		return turmaRepository.findAll();
	}
	public List<Classe> getClasse(){
		return classeRepository.findAll();
	}
	public List<Grau> getGrau(){
		return grauRepository.findAll();
	}
}