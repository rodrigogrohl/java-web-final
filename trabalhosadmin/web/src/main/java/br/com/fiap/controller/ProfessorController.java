/**
 * 
 */
package br.com.fiap.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.model.Professor;
import br.com.fiap.model.TipoDeAcesso;
import br.com.fiap.service.ProfessorService;

/**
 * @author Rodrigo
 *
 */
@ConversationScoped
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
	
	@PostConstruct
	public void init() {
		log.info("Constructing " + this.getClass().getName());
		if(service == null) {
			log.warning("Error initiazing Professor Service.");
		}
	}

	public String cadastar() {
		professor.setEscola(userSession.getEscolaSelecionada());
		professor.setTipoDeAcesso(TipoDeAcesso.PROFESSOR);
		service.cadastrar(professor);
		//getLista().add(professor);
		lista = null;
		getLista();
		log.info("Added: " + professor);
		professor = null;
		return "professor.jsf";
	}

	public List<Professor> getLista() {
		log.info("Listing Professor for Escola: #" + userSession.getEscolaSelecionada().getId());
		if(lista == null) {
			lista = service.listar(userSession.getEscolaSelecionada());
		}
		return lista;
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
