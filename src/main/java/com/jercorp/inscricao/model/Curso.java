package com.jercorp.inscricao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
public class Curso extends GenericDomain{
	@NotBlank
	@Column(length=60)
	private String descricao;
	@ManyToOne
	private Ciclo ciclo;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Ciclo getCiclo() {
		return ciclo;
	}
	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}
}
