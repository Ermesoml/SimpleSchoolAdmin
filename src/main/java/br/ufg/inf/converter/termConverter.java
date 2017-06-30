package br.ufg.inf.converter;

import br.ufg.inf.entities.Term;
import br.ufg.inf.business.contracts.ITermBo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * The Class termConverter.
 * 
 * Responsável por converter objetos de controlador para objetos de contexto
 */
@ManagedBean
@RequestScoped
public class termConverter implements Converter {

    /** The term service. */
    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;


    /* (non-Javadoc)
     * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
     */
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if (s != null && !s.equals("")) {
            return termService.retrieveTermById(Long.valueOf(s));
        }

        return null;
    }

    /* (non-Javadoc)
     * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        if (o instanceof Term) {
            Term term = (Term) o;
            return String.valueOf(term.getTermId());
        }

        return "";
    }

    /**
     * Gets the term service.
     *
     * @return the term service
     */
    public ITermBo getTermService() {
        return termService;
    }

    /**
     * Sets the term service.
     *
     * @param termService the new term service
     */
    public void setTermService(ITermBo termService) {
        this.termService = termService;
    }

}
