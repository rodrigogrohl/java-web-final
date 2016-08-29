package br.com.fiap.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.model.Disciplina;
import br.com.fiap.model.Professor;
import br.com.fiap.service.DisciplinaService;
import br.com.fiap.service.ProfessorService;

@ConversationScoped
@Named(value = "disciplinaBean")
public class DisciplinaController implements Serializable {

	private static final long serialVersionUID = 4673652807610320667L;

	private Disciplina disciplina;

	@Inject
	private DisciplinaService service;

	private List<Disciplina> lista;

	private List<Professor> professores;

	@Inject
	private ProfessorService professorService;

	private Integer idProfessorSelecionado;

	@Inject
	private UserSessionController userSession;

	public String cadastrar() {
		Professor professor = professorService.buscar(idProfessorSelecionado);
		disciplina.setProfessor(professor);
		disciplina.setCurso(userSession.getCursoSelecionado());
		
		service.cadastrar(disciplina);
		
		lista = null;		
		getLista();
		disciplina = new Disciplina();
		
		return "disciplina.jsf";
	}

	public List<Disciplina> getLista() {
		if (lista == null || lista.size() == 0)
			this.lista = service.listar(userSession.getCursoSelecionado());

		return lista;
	}

	public void setLista(List<Disciplina> lista) {
		this.lista = lista;
	}

	public Disciplina getDisciplina() {
		if (disciplina == null)
			disciplina = new Disciplina();
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Professor> getProfessores() {
		if (professores == null || professores.size() == 0) {
			professores = professorService.listar(userSession.getEscolaSelecionada());
		}
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public Integer getIdProfessorSelecionado() {
		return idProfessorSelecionado;
	}

	public void setIdProfessorSelecionado(Integer idProfessorSelecionado) {
		this.idProfessorSelecionado = idProfessorSelecionado;
	}

}
