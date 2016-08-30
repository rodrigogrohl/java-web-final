package br.com.fiap.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fiap.data.NotaRepository;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Disciplina;
import br.com.fiap.model.Nota;

@Stateless
public class NotaService {
	
	@Inject
	private NotaRepository repository;
	
	@Inject
	private DisciplinaService disciplinaService;
	
	public void cadastrar(final Nota nota){
		repository.adicionar(nota);
	}
	
	public void atualizar(final Nota nota){
		repository.atualizar(nota);
	}
	
	public Nota buscar(final Integer id) {
		return repository.buscar(id);
	}

	public List<Nota> listar(Aluno aluno) {
		return repository.listar(aluno);
	}

	public void criaMatrizNotas(Aluno aluno) {
		List<Disciplina> disciplinas = disciplinaService.listar(aluno.getCurso());
		for (Disciplina disciplina : disciplinas) {
			Nota nota = new Nota();
			nota.setDisciplina(disciplina);
			nota.setAluno(aluno);
			// nota.setProjetoUm(1.0);
			// nota.setProjetoDois(2.0);
			// nota.setAtividade(3.0);
			cadastrar(nota);
		}
		
	}
	
}
