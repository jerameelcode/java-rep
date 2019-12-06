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

import com.jercorp.inscricao.model.Grau;
import com.jercorp.inscricao.service.GrauService;

@RestController
@CrossOrigin
@RequestMapping("/inscricao-api/grau")
public class GrauController {

	@Autowired
	GrauService grauService;

	@GetMapping
	public ResponseEntity<List<Grau>> findAll() {
		return ResponseEntity.status(200).body(grauService.findAll());
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Grau> findByCodigo(@PathVariable Long codigo) {
		Optional<Grau> grau = grauService.findByCodigo(codigo);
		if (grau.isPresent()) {
			return ResponseEntity.status(200).body(grau.get());
		}
		return ResponseEntity.status(404).build();

	}

	@PostMapping
	public ResponseEntity<Grau> save(@RequestBody @Valid Grau grau) {
		Grau grauSave = grauService.save(grau);
		return ResponseEntity.status(201).body(grauSave);
	}

	@PutMapping
	public ResponseEntity<Grau> update(@RequestBody @Valid Grau grau) {
		Grau grauUpdated = grauService.update(grau);
		if (grau.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(grau);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(grauUpdated);

	}

	@DeleteMapping
	public ResponseEntity<Grau> delete(@RequestBody @Valid Grau grau) {
		if (grau.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		return ResponseEntity.status(HttpStatus.GONE).body(grauService.delete(grau));
	}
}
