/**
 * 
 */
package br.com.fiap.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Curso;
import br.com.fiap.model.Disciplina;

/**
 * @author Rodrigo
 *
 */
@ApplicationScoped
public class DisciplinaRepository extends GenericDAO<Disciplina> {

	public DisciplinaRepository() {
		super(Disciplina.class);
	}
	
	public List<Disciplina> listar(final Curso curso) {
		TypedQuery<Disciplina> query = em.createQuery("SELECT d FROM Disciplina d WHERE d.curso.id = :id", Disciplina.class);
		query.setParameter("id", curso.getId());
		return query.getResultList();
	}
	
}
