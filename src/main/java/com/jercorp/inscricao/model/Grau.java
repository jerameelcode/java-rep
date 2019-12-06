package com.jercorp.inscricao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity(name = "grau")
public class Grau extends GenericDomain{
	
	@NotBlank
	@Column(length = 60, unique=true)
	private String descricao;
	
	@ManyToMany
	@JoinTable(name = "ciclo_grau")
	private List<Ciclo> ciclo;
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Ciclo> getCiclo() {
		return ciclo;
	}

	public void setCiclo(List<Ciclo> ciclo) {
		this.ciclo = ciclo;
	} 


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grau other = (Grau) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}


	
	

}
