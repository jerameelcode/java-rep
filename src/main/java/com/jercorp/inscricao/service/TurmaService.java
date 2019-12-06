package com.jercorp.inscricao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jercorp.inscricao.model.Turma;
import com.jercorp.inscricao.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository turmaRepository;

	public List<Turma> findAll() {
		List<Turma> ciclos = turmaRepository.findAll();
		ciclos.sort((c1, c2) -> c1.getCodigo().compareTo(c2.getCodigo()));
		return ciclos;
	}

	public Optional<Turma> findByCodigo(Long codigo) {
		return turmaRepository.findByCodigo(codigo);
	}

	public Optional<Turma> findByDescricao(String descricao) {
		return turmaRepository.findByDescricao(descricao);
	}

	public Optional<Turma> findByDescricaoAndGrauAcademico(String descricao) {
		return turmaRepository.findByDescricao(descricao);
	}

	public boolean exists(Turma turma) {
		if (turmaRepository.findByDescricao(turma.getDescricao()).isPresent()) {
			return true;
		}
		return false;
	}

	public Turma save(Turma turma) {
		Optional<Turma> turmaExistente = turmaRepository.findByDescricao(turma.getDescricao());

		if (turmaExistente.isPresent()) {
			return turmaExistente.get();
		}
		turmaRepository.save(turma);
		return turmaRepository.findByDescricao(turma.getDescricao()).get();
	}

	public Turma update(Turma turma) {
		if (turmaRepository.exists(turma.getCodigo())) {
			return turmaRepository.save(turma);
		}
		return turma;
	}
	
	public Turma delete(Turma turma) {
		if(turmaRepository.exists(turma.getCodigo())) {
			turmaRepository.delete(turma);	
		}
		return turma;
	}
}
