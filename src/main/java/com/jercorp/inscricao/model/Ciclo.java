package com.jercorp.inscricao.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")

@Entity(name="ciclo")
public class Ciclo extends GenericDomain{
	@NotBlank
	@Column(length = 50, unique = true)
	private String descricao;
	
	@NotNull
	@ManyToMany
	@JoinTable(name="classe_ciclo")
	private List<Classe> classe;
	
	@ManyToMany(mappedBy="ciclo")
	private List<Grau> grau;
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<Classe> getClasses() {
		return classe;
	}

	public void setClasses(List<Classe> classes) {
		this.classe = classes;
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
		Ciclo other = (Ciclo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}


	
	
}
