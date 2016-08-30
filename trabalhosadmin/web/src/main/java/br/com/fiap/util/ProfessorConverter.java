package br.com.fiap.util;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.model.Professor;
import br.com.fiap.service.ProfessorService;

@FacesConverter(forClass = Professor.class, value = "professorConverter")
@Named
@ApplicationScoped
public class ProfessorConverter implements Converter {
 
	@Inject
	ProfessorService service;
	
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	if(service == null)
            		service = (ProfessorService) fc.getExternalContext().getApplicationMap().get("professorService");
            	
                Integer id = Integer.parseInt(value);
                return service.buscar(id);
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Professor não Localizado."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Professor) object).getId());
        }
        else {
            return null;
        }
    }   
    
}         
 