package com.jercorp.inscricao.controller;

import java.util.List;

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

import com.jercorp.inscricao.model.Aluno;
import com.jercorp.inscricao.service.AlunoService;

@RestController
@CrossOrigin
@RequestMapping("/inscricao-api/aluno")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
	}

	@GetMapping(path = "/{codigo}")
	public ResponseEntity<Aluno> findByCodigo(@PathVariable(name = "codigo") Long codigo) {
		Aluno aluno = alunoService.findByCodigo(codigo);
		if (!alunoService.exist(aluno.getNome())) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(200).body(aluno);
		}
	}

	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<List<Aluno>> findByNome(@PathVariable(name = "nome") String nome) {
		List<Aluno> aluno = alunoService.findByNome(nome);
		System.out.println(nome);
		if (aluno == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK)
				.header("Location", "/inscricao-api/aluno/").body(aluno);
	}

	@PostMapping
	public ResponseEntity<Aluno> save(@RequestBody @Valid Aluno aluno) {
		Aluno alunoSalvo = alunoService.save(aluno);
		return ResponseEntity.status(HttpStatus.CREATED)
				.header("Location", "http://localhost:8080/inscricao/aluno/" + alunoSalvo.getCodigo()).body(alunoSalvo);
	}

	@DeleteMapping
	public ResponseEntity<Aluno> delete(@RequestBody @Valid Aluno aluno) {
		alunoService.delete(aluno);
		ResponseEntity<Aluno> resposta = ResponseEntity.status(HttpStatus.GONE).body(aluno);
		return resposta;
	}

	@PutMapping
	public ResponseEntity<Aluno> update(@RequestBody @Valid Aluno aluno) {
		if (aluno.getCodigo() == null) {
			return ResponseEntity.status(403).build();
		}
		Aluno alunoUpdated = alunoService.update(aluno);
		return ResponseEntity.status(201)
				.header("Location", "http://localhost:8080/inscricao/aluno/" + alunoUpdated.getCodigo())
				.body(alunoUpdated);
	}
}
