package br.ufg.inf.converter;

import br.ufg.inf.entities.Term;
import br.ufg.inf.business.contracts.ITermBo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
@RequestScoped
public class termConverter implements Converter {

    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if (s != null && !s.equals("")) {
            return termService.retrieveTermById(Long.valueOf(s));
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        if (o instanceof Term) {
            Term term = (Term) o;
            return String.valueOf(term.getTermId());
        }

        return "";
    }

    public ITermBo getTermService() {
        return termService;
    }

    public void setTermService(ITermBo termService) {
        this.termService = termService;
    }

}
