package com.jercorp.inscricao.model;

public enum Periodo {
	
	MANHA("Manhã"),  TARDE("Tarde"), NOITE("Noite");
	
	String periodo;
	Periodo(String periodo) {
		this.periodo = periodo;
	}
	
	public String getPeriodo() {
		return periodo;
	}

}
