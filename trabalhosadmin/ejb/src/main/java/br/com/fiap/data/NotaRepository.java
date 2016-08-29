/**
 * 
 */
package br.com.fiap.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Disciplina;
import br.com.fiap.model.Nota;

/**
 * @author Rodrigo
 *
 */
@ApplicationScoped
public class NotaRepository extends GenericDAO<Nota> {

	public NotaRepository() {
		super(Nota.class);
	}

	public List<Nota> listar(Disciplina disciplina) {
		TypedQuery<Nota> query = em.createQuery("SELECT n FROM Nota n JOIN n.disciplina d WHERE d.id = :id", Nota.class);
		query.setParameter("id", disciplina.getId());
		return query.getResultList();
	}
	
}
