package br.com.fiap.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fiap.data.NotaRepository;
import br.com.fiap.model.Disciplina;
import br.com.fiap.model.Nota;

@Stateless
public class NotaService {
	
	@Inject
	private NotaRepository repository;
	
	public void cadastrar(final Nota nota){
		repository.adicionar(nota);
	}
	
	public void atualizar(final Nota nota){
		repository.atualizar(nota);
	}
	
	public List<Nota> listar() {
		return repository.listar();
	}
	
	public Nota buscar(final Integer id) {
		return repository.buscar(id);
	}

	public List<Nota> listar(Disciplina disciplina) {
		return repository.listar(disciplina);
	}
	
}
