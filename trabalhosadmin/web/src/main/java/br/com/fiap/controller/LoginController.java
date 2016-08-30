/**
 * 
 */
package br.com.fiap.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.model.TipoDeAcesso;
import br.com.fiap.model.Usuario;
import br.com.fiap.service.UsuarioService;

@SessionScoped
@Named(value = "loginBean")
public class LoginController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	
	@Inject
	private UsuarioService service;
    
	public String signUp() throws IOException {
		
		final ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
		
		if("admin".equals(username) && "admin".equals(password)) {
			
			Usuario usuario = new Usuario();
			usuario.setUsername("admin");
			usuario.setPassword("admin");
			usuario.setTipoDeAcesso(TipoDeAcesso.ADMINISTRADOR);			
			
			context.getSessionMap().put("user",  usuario);
			
			FacesContext.getCurrentInstance().getExternalContext().redirect("escola.jsf");
		}
		else {
			
			Optional<Usuario> optional = service.buscarPelasCredenciais(username, password);
			
			if(optional.isPresent()) {
				
				final Usuario usuario = optional.get();
				context.getSessionMap().put("user",  usuario);
				
				FacesContext.getCurrentInstance().getExternalContext().redirect("escola.jsf");		
			}
		}
		
		return "login";
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
