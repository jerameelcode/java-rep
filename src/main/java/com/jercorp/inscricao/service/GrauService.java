package com.jercorp.inscricao.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jercorp.inscricao.factory.GrauFactory;
import com.jercorp.inscricao.model.Grau;
import com.jercorp.inscricao.repository.GrauRepository;

@Service
public class GrauService {
	@Autowired
	GrauRepository grauRepository;

	@Autowired
	GrauFactory grauFactory;

	public Grau findByDescricao(String descricao) {
		Optional<Grau> grauEncontrado = grauRepository.findByDescricao(descricao);
		if (grauEncontrado.isPresent()) {
			return grauEncontrado.get();
		} else {
			return grauFactory.grauNulo();
		}
	}

	public List<Grau> findAll() {
		List<Grau> graus = grauRepository.findAll();
		Comparator<Grau> comparator = (g1, g2) -> g1.getCodigo().compareTo(g2.getCodigo());
		Collections.sort(graus, comparator);
		return graus;
	}

	public Optional<Grau> findByCodigo(Long codigo) {
		Optional<Grau> grau = grauRepository.findByCodigo(codigo);
		return grau;
	}

	public Grau save(Grau grau) {
		Optional<Grau> grauExistente = grauRepository.findByDescricao(grau.getDescricao());
		if (grauExistente.isPresent()) {
			return grauExistente.get();
		} else {
			grauRepository.save(grau);
			return grauRepository.findByDescricao(grau.getDescricao()).get();
		}
	}

	public Grau delete(Grau grau) {
		Optional<Grau> grauDelete = grauRepository.findByCodigo(grau.getCodigo());
		if(grauDelete.isPresent()) {
			grauRepository.delete(grau.getCodigo());
		}
		return grauDelete.get();
	}

	public Grau update(Grau grau) {
		Optional<Grau> grauUpdated = grauRepository.findByCodigo(grau.getCodigo());
		if (grauUpdated.isPresent()) {
			grauRepository.save(grau);
		}
		return grauUpdated.get();

	}

	public boolean exists(Long codigo) {
		return grauRepository.exists(codigo);
	}
}
