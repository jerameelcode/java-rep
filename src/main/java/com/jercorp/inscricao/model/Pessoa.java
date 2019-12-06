package com.jercorp.inscricao.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@MappedSuperclass
public class Pessoa extends GenericDomain{
	
	@NotBlank
	@Column(length=80)
	private String nome;
	
	@NotBlank
	private String morada;
	
	@NotBlank
	private String nacionalidade;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@NotNull
	@Column(length = 50, nullable=false)
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	
	@NotNull
	@Column(length = 50)
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMorada() {
		return morada;
	}

	public void setMorada(String morada) {
		this.morada = morada;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	

}
