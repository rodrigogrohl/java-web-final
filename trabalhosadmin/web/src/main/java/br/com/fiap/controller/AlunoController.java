package br.com.fiap.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.model.Aluno;
import br.com.fiap.model.TipoDeAcesso;
import br.com.fiap.service.AlunoService;

@ConversationScoped
@Named(value = "alunoBean")
public class AlunoController implements Serializable {
	
	private static final long serialVersionUID = 4673652807610320667L;

	private Aluno aluno;
	
	@Inject
	private AlunoService service;
	
	private List<Aluno> lista;
	
	@Inject
	private UserSessionController userSession;
	
	public String cadastrar() {
		aluno.setCurso(userSession.getCursoSelecionado());
		aluno.setTipoDeAcesso(TipoDeAcesso.ALUNO);
		service.cadastrar(aluno);		
		lista = null;
		getLista();

		aluno = new Aluno();
		return "aluno.jsf";
	}

	public List<Aluno> getLista() {
		if(lista == null)
			this.lista = service.listar(userSession.getCursoSelecionado());
		
		return lista;
	}

	public void setLista(List<Aluno> lista) {
		this.lista = lista;
	}

	public Aluno getAluno() {
		if(aluno == null)
			aluno = new Aluno();
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
