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

import br.com.fiap.model.Escola;
import br.com.fiap.service.EscolaService;

/**
 * @author Rodrigo
 *
 */

@SessionScoped
@Named(value = "escolaBean")
public class EscolaController implements Serializable {
	
	private static final long serialVersionUID = -2340054197166179506L;

	private Escola escola;
	
	private List<Escola> lista;
	
	@Inject
	private EscolaService service;
	
    @Inject
    private Logger log;
    
	public String cadastar() {
		service.cadastrar(escola);
		log.info("Persisted: " + escola);
		lista = service.listar();
		escola = null;
		return "escola.jsp";
	}

	public Escola getEscola() {
		if(escola == null)
			escola = new Escola();
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public List<Escola> getLista() {
		if(lista == null)
			lista = service.listar();
		return lista;
	}

	public void setLista(List<Escola> lista) {
		this.lista = lista;
	}
	
}
