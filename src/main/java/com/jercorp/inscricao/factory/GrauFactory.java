package com.jercorp.inscricao.factory;

import javax.annotation.ManagedBean;

import com.jercorp.inscricao.model.Grau;

@ManagedBean
public class GrauFactory {
	
	public Grau grauNulo() {
		Grau grauNulo = new Grau();
		grauNulo.setDescricao("");
		return grauNulo;
	}
	
	public Grau novoGrau(String grau) {
		Grau grauCriado = new Grau();
		grauCriado.setDescricao(grau);
		return grauCriado;
	};

}
