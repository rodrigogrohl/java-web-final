/**
 * 
 */
package br.com.fiap.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.model.Professor;
import br.com.fiap.service.ProfessorService;

/**
 * @author Rodrigo
 *
 */
@SessionScoped
@Named(value = "professorBean")
public class ProfessorController implements Serializable {
	
	private static final long serialVersionUID = -2340054197166179506L;

	@Inject
	private UserSessionController userSession;
	
	private Professor professor;
	
	@Inject
	private ProfessorService service;
	
	private List<Professor> lista;
	
	@Inject
	private Logger log;

	public String cadastar() {
		service.cadastrar(professor);
		getLista().add(professor);
		log.info("Added: " + professor);
		professor = null;
		return "professor.jsf";
	}

	public List<Professor> getLista() {
		if(userSession.getEscolaSelecionada().getProfessores() == null) {
			lista = service.listar(userSession.getEscolaSelecionada());
			userSession.getEscolaSelecionada().setProfessores(lista);
		}
		return userSession.getEscolaSelecionada().getProfessores();
	}
	
	/*
	 * 
	public int getTotalProfessores() {
		return this.getLista().size();
	}
	 */

	public Professor getProfessor() {
		if(professor == null)
			professor = new Professor();
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	
}
