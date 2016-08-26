/**
 * 
 */
package br.com.fiap.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

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
		Escola reference = em.getReference(Escola.class, escola);
		return reference.getProfessores();
	}
	
}
