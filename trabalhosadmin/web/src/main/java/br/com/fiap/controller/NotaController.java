package br.com.fiap.controller;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import br.com.fiap.model.Nota;
import br.com.fiap.service.NotaService;

@ConversationScoped
@Named(value = "notaBean")
public class NotaController implements Serializable {
	
	private static final long serialVersionUID = 4673652807610320667L;

	private Nota nota;
	
	@Inject
	private NotaService service;
	
	private List<Nota> lista;
	
	@Inject
	private UserSessionController userSession;
	
    public void onRowEdit(RowEditEvent event) {
        nota = (Nota) event.getObject();
        service.atualizar(nota);
        
        FacesMessage msg = new FacesMessage("Nota Editada", nota.getStatus());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edição Cancelada");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Nota Alterada", "De: " + oldValue + ", Para:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
	
	public String cadastrar() {
		service.cadastrar(nota);
		getLista().add(nota);
		nota = new Nota();
		return "nota.jsf";
	}

	public List<Nota> getLista() {
		if(lista == null)
			this.lista = service.listar(userSession.getAlunoSelecionado());
		
		return lista;
	}

	public void setLista(List<Nota> lista) {
		this.lista = lista;
	}

	public Nota getNota() {
		if(nota == null)
			nota = new Nota();
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

}
