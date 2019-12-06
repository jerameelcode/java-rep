package com.jercorp.inscricao.factory;

import java.util.Date;

import javax.annotation.ManagedBean;

import com.jercorp.inscricao.model.Aluno;
import com.jercorp.inscricao.model.Classe;
import com.jercorp.inscricao.model.Sexo;
import com.jercorp.inscricao.model.Turma;

@ManagedBean
public class AlunoFactory {
	
	public boolean isNull(Aluno aluno) {
		return aluno==this.alunoNull();
	}
	
	
	public Aluno alunoNull() {
		Aluno alunoNulo = new Aluno();
		alunoNulo.setCodigo(0L);
		alunoNulo.setNome("");
		alunoNulo.setClasse(new Classe());
		alunoNulo.setDataNascimento(new Date(System.currentTimeMillis()));
		alunoNulo.setMorada("");
		alunoNulo.setNacionalidade("");
		alunoNulo.setSexo(Sexo.MASCULINO);
		alunoNulo.setTurma(new Turma());
		return alunoNulo;
	}

}
