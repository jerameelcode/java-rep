package com.jercorp.inscricao.model;

public enum Sexo {
	MASCULINO ("Masculino"), FEMENINO("Femenino");
	
	private String sexo;
	
	Sexo(String sexo){
		this.sexo = sexo;  
	}
	
	public String getSexo() {
		return sexo;
	}
}
