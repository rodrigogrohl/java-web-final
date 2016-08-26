/**
 * 
 */
package br.com.fiap.data;

import javax.enterprise.context.ApplicationScoped;

import br.com.fiap.model.Escola;

/**
 * @author Rodrigo
 *
 */
@ApplicationScoped
public class EscolaRepository extends GenericDAO<Escola> {

	public EscolaRepository() {
		super(Escola.class);
	}
	

}
