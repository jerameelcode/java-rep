package com.jercorp.inscricao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jercorp.inscricao.model.Grau;
import com.jercorp.inscricao.model.Mensalidade;
import com.jercorp.inscricao.repository.MensalidadeRepository;

@Service
public class MensalidadeService {

	@Autowired
	MensalidadeRepository mensalidadeRepository;

	public List<Mensalidade> findAll() {
		List<Mensalidade> mensalidades = mensalidadeRepository.findAll();
		mensalidades.sort((c1, c2) -> c1.getCodigo().compareTo(c2.getCodigo()));
		return mensalidades;
	}

	public Optional<Mensalidade> findByCodigo(Long codigo) {
		return mensalidadeRepository.findByCodigo(codigo);
	}

	public Optional<Mensalidade> findByDescricao(String descricao) {
		return mensalidadeRepository.findByDescricao(descricao);
	}

	public Optional<Mensalidade> findByDescricaoAndGrauAcademico(String descricao, Grau grau) {
		return mensalidadeRepository.findByDescricao(descricao);
	}

	public boolean exists(Mensalidade mensalidade) {
		if (mensalidadeRepository.findByDescricao(mensalidade.getDescricao()).isPresent()) {
			return true;
		}
		return false;
	}

	public Mensalidade save(Mensalidade mensalidade) {
		Optional<Mensalidade> mensalidadeExistente = mensalidadeRepository.findByDescricao(mensalidade.getDescricao());

		if (mensalidadeExistente.isPresent()) {
			return mensalidadeExistente.get();
		}
		mensalidadeRepository.save(mensalidade);
		return mensalidadeRepository.findByDescricao(mensalidade.getDescricao()).get();
	}

	public Mensalidade update(Mensalidade mensalidade) {
		if (mensalidadeRepository.exists(mensalidade.getCodigo())) {
			System.out.println("Executou o serviço save()");
			return mensalidadeRepository.save(mensalidade);
		}
		return mensalidade;
	}
	

	public Mensalidade delete(Mensalidade mensalidade) {
		if(mensalidadeRepository.exists(mensalidade.getCodigo())) {
			mensalidadeRepository.delete(mensalidade);	
		}
		return mensalidade;
	}
}
