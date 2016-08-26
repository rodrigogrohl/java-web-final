/**
 * 
 */
package br.com.fiap.data;

import javax.enterprise.context.ApplicationScoped;

import br.com.fiap.model.Aluno;

/**
 * @author Rodrigo
 *
 */
@ApplicationScoped
public class AlunoRepository extends GenericDAO<Aluno> {

	public AlunoRepository() {
		super(Aluno.class);
	}
	
}
