package br.com.fiap.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fiap.data.EscolaRepository;
import br.com.fiap.model.Escola;

@Stateless
public class EscolaService {
	
	@Inject
	private EscolaRepository repository;
	
	public void cadastrar(final Escola escola){
		repository.adicionar(escola);
	}
	
	public void atualizar(final Escola escola){
		repository.atualizar(escola);
	}
	
	public List<Escola> listar() {
		return repository.listar();
	}
	
	public Escola buscar(final Integer id) {
		return repository.buscar(id);
	}
	

}
