package br.com.fiap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ALUNO")
public class Aluno extends Usuario implements Serializable {

	private static final long serialVersionUID = -1857734097599240132L;
	
	@NotNull
	@Column
	private String nome;
	
	@ManyToMany
	private List<Curso> cursos;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", nome=" + nome + ", cursos=" + cursos + "]";
	}
	
}
