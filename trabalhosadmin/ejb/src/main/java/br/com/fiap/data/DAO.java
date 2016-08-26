package br.com.fiap.data;

import java.util.List;

public interface DAO<T> {
	
	void adicionar(T entidade);
	List<T> listar();
	void atualizar(T entidade);
	void remover(T entidade);
	T buscar(int id);
	
}