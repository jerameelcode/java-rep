package com.jercorp.inscricao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jercorp.inscricao.model.Ciclo;
import com.jercorp.inscricao.model.Classe;
import com.jercorp.inscricao.model.Curso;
import com.jercorp.inscricao.model.Grau;
import com.jercorp.inscricao.model.Mensalidade;
import com.jercorp.inscricao.model.Turma;
import com.jercorp.inscricao.service.CicloService;
import com.jercorp.inscricao.service.ClasseService;
import com.jercorp.inscricao.service.CursoService;
import com.jercorp.inscricao.service.GrauService;
import com.jercorp.inscricao.service.MensalidadeService;
import com.jercorp.inscricao.service.TurmaService;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/inscricao-api/util")
public class UtilController {

	@Autowired
	CicloService cicloService;
	@Autowired
	CursoService cursoService;
	@Autowired
	TurmaService turmaService;
	@Autowired
	ClasseService classeService;
	@Autowired
	GrauService grauService;
	@Autowired
	MensalidadeService mensalidadeService;
	
	

	@GetMapping("/ciclos")
	public ResponseEntity<List<Ciclo>> findCiclos() {
		List<Ciclo> ciclos = cicloService.findAll();
		return ResponseEntity.status(200).body(ciclos);
	}
	
	@GetMapping("/cursos")
	public ResponseEntity<List<Curso>> findCursos() {
		List<Curso> cursos = cursoService.findAll();
		return ResponseEntity.status(200).body(cursos);
	}
	@GetMapping("/turmas")
	public ResponseEntity<List<Turma>> findTurmas() {
		List<Turma> turmas = turmaService.findAll();
		return ResponseEntity.status(200).body(turmas);
	}
	@GetMapping("/classes")
	public ResponseEntity<List<Classe>> findClasses() {
		List<Classe> classes = classeService.findAll();
		return ResponseEntity.status(200).body(classes);
	}
	@GetMapping("/graus")
	public ResponseEntity<List<Grau>> findGraus() {
		List<Grau> graus= grauService.findAll();
		return ResponseEntity.status(200).body(graus);
	}
	@GetMapping("/mensalidades")
	public ResponseEntity<List<Mensalidade>> findMensalidades() {
		List<Mensalidade> mensalidades = mensalidadeService.findAll();
		return ResponseEntity.status(200).body(mensalidades);
	}
}
