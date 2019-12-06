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

import com.jercorp.inscricao.model.Curso;
import com.jercorp.inscricao.service.CursoService;

@RestController
@CrossOrigin
@RequestMapping("/inscricao-api/curso")
public class CursoController {

	@Autowired
	CursoService cursoService;

	@GetMapping
	public ResponseEntity<List<Curso>> findAll() {
		return ResponseEntity.status(200).body(cursoService.findAll());
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Curso> findByCodigo(@PathVariable Long codigo) {
		Optional<Curso> curso = cursoService.findByCodigo(codigo);
		if (curso.isPresent()) {
			return ResponseEntity.status(200).body(curso.get());
		}
		return ResponseEntity.status(404).build();
	}

	@PostMapping
	public ResponseEntity<Curso> save(@RequestBody @Valid Curso curso) {
		Curso cursoSalvo = cursoService.save(curso);
		return ResponseEntity.status(201)
				.header("Location", "/inscricao-api/curso/"+cursoSalvo.getCodigo())
				.body(cursoSalvo);
	}

	@PutMapping
	public ResponseEntity<Curso> update(@RequestBody @Valid Curso curso) {
		Curso cursoUpdate = cursoService.update(curso);
		if (curso.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(curso);
		}
		return ResponseEntity.status(HttpStatus.CREATED)
				.header("Location", "/inscricao-api/curso/"+cursoUpdate.getCodigo())
				.body(cursoUpdate);
	}

	@DeleteMapping
	public ResponseEntity<Curso> delete(@RequestBody @Valid Curso curso) {
		if (curso.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		return ResponseEntity.status(HttpStatus.GONE).body(cursoService.delete(curso));
	}
}
