package br.com.fiap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PROFESSOR")
public class Professor extends Usuario implements Serializable {

	private static final long serialVersionUID = -7069693917587336296L;	
	
	@NotNull
	@Column
	private String nome;
	
	@ManyToOne
	@NotNull
	private Escola escola;
	
	@OneToMany
	private List<Disciplina> disciplinas;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + "]";
	}
	
}
