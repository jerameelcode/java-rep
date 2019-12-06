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

import com.jercorp.inscricao.model.Ciclo;
import com.jercorp.inscricao.service.CicloService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/inscricao-api/ciclo")
public class CicloController {

	@Autowired
	CicloService cicloService;

	@GetMapping
	public ResponseEntity<List<Ciclo>> findAll() {
		List<Ciclo> ciclos = cicloService.findAll();
		return ResponseEntity.status(200).body(ciclos);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Ciclo> findByCodigo(@PathVariable Long codigo) {
		Optional<Ciclo> ciclo = cicloService.findByCodigo(codigo);
		if (ciclo.isPresent()) {
			return ResponseEntity.status(200).body(ciclo.get());
		}
		return ResponseEntity.status(404).build();

	}

	@PostMapping
	public ResponseEntity<Ciclo> save(@RequestBody @Valid Ciclo ciclo) {
		Ciclo cicloSave = cicloService.save(ciclo);
		return ResponseEntity.status(201).body(cicloSave);
	}

	@PutMapping
	public ResponseEntity<Ciclo> update(@RequestBody @Valid Ciclo ciclo) {

		if (ciclo.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Ciclo cicloUpdate = cicloService.update(ciclo);
		return ResponseEntity.status(HttpStatus.CREATED)
				.location(URI.create("/inscricao-api/ciclo/"+cicloUpdate
						.getCodigo())).body(cicloUpdate);

	}

	@DeleteMapping
	public ResponseEntity<Ciclo> delete(@RequestBody @Valid Ciclo ciclo) {
		if (ciclo.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		return ResponseEntity.status(HttpStatus.GONE).body(cicloService.delete(ciclo));
	}
}
