package br.com.fiap.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ESCOLA")
public class Escola implements Serializable {
	
	private static final long serialVersionUID = 8825909197924628410L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column
	private String nome;
	
	@OneToMany(fetch = FetchType.EAGER)
	private List<Curso> cursos;
	
	@OneToMany
	private List<Professor> professores;
	
	public int getTotalCursos() {
		if(cursos != null) {
			return cursos.size();
		}
		return 0;
	}
	
	public int getTotalProfessores() {
		if(professores != null) {
			return professores.size();
		}
		return 0;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	@Override
	public String toString() {
		return "Escola [id=" + id + ", nome=" + nome + ", cursos=" + cursos + "]";
	}
	

}
