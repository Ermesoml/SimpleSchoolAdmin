package br.ufg.inf.bean.admin;


import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ITermBo;
import br.ufg.inf.entities.Term;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class ListTermBean.
 */
@ManagedBean(name = "listTermBean")
@ViewScoped
public class ListTermBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6890734164836174025L;

	/** The term service. */
    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;

    /** The model. */
    private transient DataModel<Term> model;

    /** The term. */
    private Term term = new Term();
    
    /** The terms. */
    private List<Term> terms = new ArrayList<>();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init(){
        terms = termService.listAll();
    }

    /**
     * Edits the term.
     *
     * @return the string
     */
    public String editTerm() {

        flashContainer().put("term", model.getRowData());
        return "/admin/editTurma.xhtml?faces-redirect=true";

    }

    /**
     * Delete term.
     *
     * @return the string
     */
    public String deleteTerm(){

        try {
            termService.deleteTerm(model.getRowData());
            terms.remove(model.getRowData());
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "/admin/gerTurmas.xhtml";
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    //region Getter and Setter
    public DataModel<Term> getModel() {

        if (model == null) {
            model = new ListDataModel<>(terms);
        }

        return model;
    }


    /**
     * Gets the term.
     *
     * @return the term
     */
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
     * Sets the model.
     *
     * @param model the new model
     */
    public void setModel(DataModel<Term> model) {
        this.model = model;
    }

    /**
     * Gets the terms.
     *
     * @return the terms
     */
    public List<Term> getTerms() {
        return terms;
    }

    /**
     * Sets the terms.
     *
     * @param terms the new terms
     */
    public void setTerms(List<Term> terms) {
        this.terms = terms;
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
