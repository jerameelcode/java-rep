package com.jercorp.inscricao.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Mensalidade extends GenericDomain{
	
	@Column
	private boolean isPago;
	@Column
	private String descricao;
	@Column
	private BigDecimal valor;
	
	@ManyToOne
	private Aluno aluno;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isPago() {
		return isPago;
	}

	public void setPago(boolean isPago) {
		this.isPago = isPago;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
