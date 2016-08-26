/**
 * 
 */
package br.com.fiap.data;

import javax.enterprise.context.ApplicationScoped;

import br.com.fiap.model.Curso;

/**
 * @author Rodrigo
 *
 */
@ApplicationScoped
public class CursoRepository extends GenericDAO<Curso> {

	public CursoRepository() {
		super(Curso.class);
	}
	

}
