package com.jercorp.inscricao.controller;

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

import com.jercorp.inscricao.model.Classe;
import com.jercorp.inscricao.service.ClasseService;

@RestController
@CrossOrigin
@RequestMapping("/inscricao-api/classe")
public class ClasseController {

	@Autowired
	ClasseService classeService;

	@GetMapping
	public ResponseEntity<List<Classe>> findAll() {
		return ResponseEntity.status(200).body(classeService.findAll());
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Classe> findByCodigo(@PathVariable Long codigo) {
		Optional<Classe> classe = classeService.findByCodigo(codigo);
		if (classe.isPresent()) {
			return ResponseEntity.status(200).body(classe.get());
		}
		return ResponseEntity.status(404).build();
	}

	@PostMapping
	public ResponseEntity<Classe> save(@RequestBody @Valid Classe classe) {
		return ResponseEntity.status(201).body(classeService.save(classe));
	}

	@PutMapping
	public ResponseEntity<Classe> update(@RequestBody @Valid Classe classe) {
		Classe classeUpdate = classeService.update(classe);
		if (classe.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(classe);
		}
		return ResponseEntity.status(HttpStatus.OK).body(classeUpdate);
	}

	@DeleteMapping
	public ResponseEntity<Classe> delete(@RequestBody @Valid Classe classe) {
		if (classe.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		return ResponseEntity.status(HttpStatus.GONE).body(classeService.delete(classe));
	}
}
