/**
 * 
 */
package br.com.fiap.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.model.Curso;
import br.com.fiap.service.CursoService;

/**
 * @author Rodrigo
 *
 */
@SessionScoped
@Named(value = "cursoBean")
public class CursoController implements Serializable {
	
	private static final long serialVersionUID = -2340054197166179506L;

	@Inject
	private UserSessionController userSession;
	
	private Curso curso;
	
	@Inject
	private CursoService service;
	
	@Inject
	private Logger log;

	public String cadastar() {
		service.cadastrar(curso);
		getLista().add(curso);
		log.info("Added: " + curso);
		curso = null;
		return "curso.jsf";
	}

	public Curso getCurso() {
		if(curso == null)
			curso = new Curso();
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getLista() {
		if(userSession.getEscolaSelecionada().getCursos() == null)
			userSession.getEscolaSelecionada().setCursos(new ArrayList<Curso>());
		return userSession.getEscolaSelecionada().getCursos();
	}
	
}
