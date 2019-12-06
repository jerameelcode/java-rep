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

import com.jercorp.inscricao.model.Mensalidade;
import com.jercorp.inscricao.service.MensalidadeService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/inscricao-api/mensalidade")
public class MensalidadeController {

	@Autowired
	MensalidadeService mensalidadeService;

	@GetMapping
	public ResponseEntity<List<Mensalidade>> findAll() {
		List<Mensalidade> mensalidades = mensalidadeService.findAll();
		return ResponseEntity.status(200).body(mensalidades);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Mensalidade> findByCodigo(@PathVariable Long codigo) {
		Optional<Mensalidade> mensalidade = mensalidadeService.findByCodigo(codigo);
		if (mensalidade.isPresent()) {
			return ResponseEntity.status(200).body(mensalidade.get());
		}
		return ResponseEntity.status(404).build();

	}

	@PostMapping
	public ResponseEntity<Mensalidade> save(@RequestBody @Valid Mensalidade mensalidade) {
		Mensalidade mensalidadeSave = mensalidadeService.save(mensalidade);
		return ResponseEntity.status(201).body(mensalidadeSave);
	}

	@PutMapping
	public ResponseEntity<Mensalidade> update(@RequestBody @Valid Mensalidade mensalidade) {

		if (mensalidade.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		Mensalidade mensalidadeUpdate = mensalidadeService.update(mensalidade);
		return ResponseEntity.status(HttpStatus.CREATED)
				.location(URI.create("/inscricao-api/mensalidade/"+mensalidadeUpdate
						.getCodigo())).body(mensalidadeUpdate);

	}

	@DeleteMapping
	public ResponseEntity<Mensalidade> delete(@RequestBody @Valid Mensalidade mensalidade) {
		if (mensalidade.getCodigo() == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		return ResponseEntity.status(HttpStatus.GONE).body(mensalidadeService.delete(mensalidade));
	}
}
