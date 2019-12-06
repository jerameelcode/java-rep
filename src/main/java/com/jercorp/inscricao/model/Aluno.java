package com.jercorp.inscricao.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@DiscriminatorValue("Aluno")
public class Aluno extends Pessoa{
	
	@NotNull
	@ManyToOne
	private Classe classe;
	
	@ManyToOne
	private Turma turma;
	
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
}
