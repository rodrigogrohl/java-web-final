package br.com.fiap.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fiap.data.CursoRepository;
import br.com.fiap.model.Curso;

@Stateless
public class CursoService {
	
	@Inject
	private CursoRepository repository;
	
	public void cadastrar(final Curso curso){
		repository.adicionar(curso);
	}
	
	public void atualizar(final Curso curso){
		repository.atualizar(curso);
	}
	
	public List<Curso> listar() {
		return repository.listar();
	}
	
	public Curso buscar(final Integer id) {
		return repository.buscar(id);
	}
	

}
