package br.com.fiap.model;

public enum TipoDeAcesso {
	PROFESSOR, ADMINISTRADOR, ALUNO;
	
	public boolean ehProfessor() {
		return this == PROFESSOR;
	}
	
	public boolean ehAluno() {
		return this == ALUNO;
	}
	
	public boolean ehAdministrador() {
		return this == ADMINISTRADOR;
	}
}
