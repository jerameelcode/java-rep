package com.jercorp.inscricao.model;

public enum EstadoCivil {
	SOLTEIRO("Solteiro"), CASADO("Casado"), DIVORCIADO("Divorciado"), VIUVO("Viúvo");
	
	private String estadoCivil;
	
	EstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}
}
