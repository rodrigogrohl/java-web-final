/**
 * 
 */
package br.com.fiap.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Aluno;
import br.com.fiap.model.Curso;

/**
 * @author Rodrigo
 *
 */
@ApplicationScoped
public class AlunoRepository extends GenericDAO<Aluno> {

	public AlunoRepository() {
		super(Aluno.class);
	}

	public List<Aluno> listar(Curso cursoSelecionado) {
		TypedQuery<Aluno> query = em.createQuery("SELECT a FROM Aluno a JOIN a.curso c WHERE c.id = :id", Aluno.class);
		query.setParameter("id", cursoSelecionado.getId());
		return query.getResultList();
	}

}
