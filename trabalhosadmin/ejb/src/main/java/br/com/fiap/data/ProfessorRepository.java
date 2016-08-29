/**
 * 
 */
package br.com.fiap.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Escola;
import br.com.fiap.model.Professor;

/**
 * @author Rodrigo
 *
 */
@ApplicationScoped
public class ProfessorRepository extends GenericDAO<Professor> {

	public ProfessorRepository() {
		super(Professor.class);
	}
	
	public List<Professor> listar(final Escola escola) {
		TypedQuery<Professor> query = em.createQuery("SELECT p FROM Professor p WHERE p.escola.id = :id", Professor.class);
		query.setParameter("id", escola.getId());
		return query.getResultList();
	}
	
}
