package br.ufg.inf.bean.admin;

import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ITermBo;
import br.ufg.inf.entities.Term;
import br.ufg.inf.entities.TermCourses;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class EditTermBean.
 */
@ManagedBean(name = "editTermBean")
@RequestScoped
public class EditTermBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7479389270949855170L;

	/** The term service. */
    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;

    /** The model. */
    private transient DataModel<TermCourses> model;
    
    /** The term. */
    private Term term = new Term();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init(){
        term = (Term) flashContainer().get("term");
    }

    /**
     * Edits the term.
     *
     * @return the string
     */
    public String editTerm(){

        try{
            termService.updateTerm(term);
        }catch (Exception ex){
            ex.printStackTrace();
            return "";
        }

        return "/admin/gerTurmas.xhtml?faces-redirect=true";
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public DataModel<TermCourses> getModel() {

        List<TermCourses> courses = new ArrayList<>();
        courses.addAll(term.getTermCourses());

        if (model == null) {
            model = new ListDataModel<>(courses);
        }

        return model;
    }

    /**
     * Gets the term.
     *
     * @return the term
     */
    //region Getters and Setters
    public Term getTerm() {
        return term;
    }

    /**
     * Sets the term.
     *
     * @param term the new term
     */
    public void setTerm(Term term) {
        this.term = term;
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
    //endregion


}
