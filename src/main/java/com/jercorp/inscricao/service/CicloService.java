package com.jercorp.inscricao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jercorp.inscricao.model.Ciclo;
import com.jercorp.inscricao.model.Grau;
import com.jercorp.inscricao.repository.CicloRepository;

@Service
public class CicloService {

	@Autowired
	CicloRepository cicloRepository;

	public List<Ciclo> findAll() {
		List<Ciclo> ciclos = cicloRepository.findAll();
		ciclos.sort((c1, c2) -> c1.getCodigo().compareTo(c2.getCodigo()));
		return ciclos;
	}

	public Optional<Ciclo> findByCodigo(Long codigo) {
		return cicloRepository.findByCodigo(codigo);
	}

	public Optional<Ciclo> findByDescricao(String descricao) {
		return cicloRepository.findByDescricao(descricao);
	}

	public Optional<Ciclo> findByDescricaoAndGrauAcademico(String descricao, Grau grau) {
		return cicloRepository.findByDescricao(descricao);
	}

	public boolean exists(Ciclo ciclo) {
		if (cicloRepository.findByDescricao(ciclo.getDescricao()).isPresent()) {
			return true;
		}
		return false;
	}

	public Ciclo save(Ciclo ciclo) {
		Optional<Ciclo> cicloExistente = cicloRepository.findByDescricao(ciclo.getDescricao());

		if (cicloExistente.isPresent()) {
			return cicloExistente.get();
		}
		cicloRepository.save(ciclo);
		return cicloRepository.findByDescricao(ciclo.getDescricao()).get();
	}

	public Ciclo update(Ciclo ciclo) {
		if (cicloRepository.exists(ciclo.getCodigo())) {
			System.out.println("Executou o serviço save()");
			return cicloRepository.save(ciclo);
		}
		return ciclo;
	}
	

	public Ciclo delete(Ciclo ciclo) {
		if(cicloRepository.exists(ciclo.getCodigo())) {
			cicloRepository.delete(ciclo);	
		}
		return ciclo;
	}
}
