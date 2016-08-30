/**
 * 
 */
package br.com.fiap.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;

import br.com.fiap.model.Aluno;
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

	public List<Nota> listar(Aluno aluno) {
		TypedQuery<Nota> query = em.createQuery("SELECT n FROM Nota n JOIN n.aluno a WHERE a.id = :alunoId", Nota.class);
		// query.setParameter("disciplinaId", disciplina.getId());
		query.setParameter("alunoId", aluno.getId());
		return query.getResultList();
	}
	
}
