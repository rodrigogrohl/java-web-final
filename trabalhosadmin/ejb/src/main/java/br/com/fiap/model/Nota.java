package br.com.fiap.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "NOTA")
public class Nota implements Serializable {

	private static final long serialVersionUID = -8766707198282207106L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Disciplina disciplina;

	@ManyToOne
	private Aluno aluno;

	@Column
	@Min(value = 0, message = "Nota deve ser maior que 0.") 
	@Max(value = 10, message = "Nota deve ser menor que 10.")
	private Double projetoUm; // 30%

	@Column
	@Min(value = 0, message = "Nota deve ser maior que 0.") 
	@Max(value = 10, message = "Nota deve ser menor que 10.")
	private Double atividade; // 30%

	@Column
	@Min(value = 0, message = "Nota deve ser maior que 0.") 
	@Max(value = 10, message = "Nota deve ser menor que 10.")
	private Double projetoDois; // 40%
	
	public Double calculaMedia() {
		return (( projetoUm * 30 ) +
				( atividade * 30 ) +
				(projetoDois * 40) ) / 100;
	}
	
	public boolean isAprovado() {
		if(calculaMedia() > 7) {
			return true;
		}
		return false;
	}
	
	public String getStatus() {
		if(projetoUm == null || projetoDois == null || atividade == null)
			return "Em avaliação";
		
		if(isAprovado())
			return "Aprovado";
		
		return "Reprovado";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Double getProjetoUm() {
		return projetoUm;
	}

	public void setProjetoUm(Double projetoUm) {
		this.projetoUm = projetoUm;
	}

	public Double getAtividade() {
		return atividade;
	}

	public void setAtividade(Double atividade) {
		this.atividade = atividade;
	}

	public Double getProjetoDois() {
		return projetoDois;
	}

	public void setProjetoDois(Double projetoDois) {
		this.projetoDois = projetoDois;
	}

}
