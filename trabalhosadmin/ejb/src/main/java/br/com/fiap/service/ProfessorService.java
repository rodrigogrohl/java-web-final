package br.com.fiap.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fiap.data.ProfessorRepository;
import br.com.fiap.model.Escola;
import br.com.fiap.model.Professor;

@Stateless
public class ProfessorService {
	
	@Inject
	private ProfessorRepository repository;
	
	public void cadastrar(final Professor professor){
		repository.adicionar(professor);
	}
	
	public void atualizar(final Professor professor){
		repository.atualizar(professor);
	}
	
	public List<Professor> listar(final Escola escola) {
		return repository.listar(escola);
	}
	
	public Professor buscar(final Integer id) {
		return repository.buscar(id);
	}
	

}
