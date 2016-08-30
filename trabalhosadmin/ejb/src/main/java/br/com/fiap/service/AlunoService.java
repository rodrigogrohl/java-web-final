package br.com.fiap.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fiap.data.AlunoRepository;
import br.com.fiap.model.Aluno;
import br.com.fiap.model.Curso;

@Stateless
public class AlunoService {
	
	@Inject
	private AlunoRepository repository;
	
	@Inject
	private NotaService notaService;
	
	public void cadastrar(final Aluno aluno){
		repository.adicionar(aluno);
		notaService.criaMatrizNotas(aluno);
	}
	
	public void atualizar(final Aluno aluno){
		repository.atualizar(aluno);
	}
	
	public List<Aluno> listar() {
		return repository.listar();
	}
	
	public Aluno buscar(final Integer id) {
		return repository.buscar(id);
	}

	public List<Aluno> listar(Curso cursoSelecionado) {
		return repository.listar(cursoSelecionado);
	}
	
}
