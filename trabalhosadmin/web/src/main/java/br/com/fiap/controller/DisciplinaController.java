package br.com.fiap.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.model.Disciplina;
import br.com.fiap.service.DisciplinaService;

@SessionScoped
@Named(value = "disciplinaBean")
public class DisciplinaController implements Serializable {
	
	private static final long serialVersionUID = 4673652807610320667L;

	private Disciplina disciplina;
	
	@Inject
	private DisciplinaService service;
	
	private List<Disciplina> lista;
	
	@Inject
	private UserSessionController userSession;
	
	public String cadastrar() {
		service.cadastrar(disciplina);
		getLista().add(disciplina);
		disciplina = new Disciplina();
		return "disciplina.jsf";
	}

	public List<Disciplina> getLista() {
		if(lista == null)
			this.lista = service.listar(userSession.getCursoSelecionado());
		
		return lista;
	}

	public void setLista(List<Disciplina> lista) {
		this.lista = lista;
	}

	public Disciplina getDisciplina() {
		if(disciplina == null)
			disciplina = new Disciplina();
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

}
