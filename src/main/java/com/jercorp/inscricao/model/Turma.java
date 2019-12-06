package com.jercorp.inscricao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
public class Turma extends GenericDomain{
	@NotBlank
	@Column(length=30, nullable=false, unique=true)
	private String descricao;
	@NotNull
	@ManyToOne
	private Classe classe;
	@NotNull
	@ManyToOne
	private Curso curso;
	@NotBlank
	@Enumerated(EnumType.STRING)
	private Periodo periodo;
	
	@NotEmpty
	private Integer sala;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
}