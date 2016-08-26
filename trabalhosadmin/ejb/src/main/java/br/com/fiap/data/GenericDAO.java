package br.com.fiap.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAO<T> implements DAO<T> {
	
	private final Class<T> classe;
	
	@PersistenceContext
	protected EntityManager em;

	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void adicionar(T entidade) {
		em.persist(entidade);
	}

	@Override
	public List<T> listar() {
		return em.createQuery("From " + classe.getSimpleName(), classe).getResultList();
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}

	@Override
	public void remover(T entidade) {
		em.remove(em.merge(entidade));
	}

	@Override
	public T buscar(int id) {
		return em.find(classe, id);
	}
}
