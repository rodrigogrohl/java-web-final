/**
 * 
 */
package br.com.fiap.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.fiap.model.Curso;
import br.com.fiap.model.Escola;

/**
 * @author Rodrigo
 *
 */

@SessionScoped
@Named(value = "userSessionBean")
public class UserSessionController implements Serializable {

	private static final long serialVersionUID = -2340054197166179506L;

	private Escola escolaSelecionada;

	private Curso cursoSelecionado;
	
	public Escola getEscolaSelecionada() {
		return escolaSelecionada;
	}

	public void setEscolaSelecionada(Escola escolaSelecionada) {
		this.escolaSelecionada = escolaSelecionada;
		
	}

	public Curso getCursoSelecionado() {
		return cursoSelecionado;
	}

	public void setCursoSelecionado(Curso cursoSelecionado) {
		this.cursoSelecionado = cursoSelecionado;
	}

}
