package com.jercorp.inscricao.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jercorp.inscricao.model.Turma;
import com.jercorp.inscricao.service.TurmaService;

@RestController
@CrossOrigin
@RequestMapping("/inscricao-api/turma")
public class TurmaController {
	@Autowired
	TurmaService turmaService;

	@GetMapping
	public ResponseEntity<List<Turma>> findAll() {
		List<Turma> turma = turmaService.findAll();
		return ResponseEntity.status(200).body(turma);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Turma> findByCodigo(@PathVariable Long codigo) {
		Optional<Turma> turma = turmaService.findByCodigo(codigo);
		if (turma.isPresent()) {
			return ResponseEntity.status(200).body(turma.get());
		}
		return ResponseEntity.status(404).build();

	}

	@PostMapping
	public ResponseEntity<Turma> save(@RequestBody @Valid Turma turma) {
		Turma turmaSave = turmaService.save(turma);
		return ResponseEntity.status(201).body(turmaSave);
	}

	@PutMapping
	public ResponseEntity<Turma> update(@RequestBody @Valid Turma turma) {
		if (turma.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Turma turmaUpdate = turmaService.update(turma);
		return ResponseEntity.status(HttpStatus.CREATED)
				.location(URI.create("/inscricao-api/turma/"+turmaUpdate
						.getCodigo())).body(turmaUpdate);
	}

	@DeleteMapping
	public ResponseEntity<Turma> delete(@RequestBody @Valid Turma turma) {
		if (turma.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		return ResponseEntity.status(HttpStatus.GONE).body(turmaService.delete(turma));
	}
}
