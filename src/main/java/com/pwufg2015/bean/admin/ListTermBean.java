package com.pwufg2015.bean.admin;


import com.pwufg2015.bean.MB;
import com.pwufg2015.business.TermBo;
import com.pwufg2015.business.contracts.ITermBo;
import com.pwufg2015.business.contracts.ITermBo;
import com.pwufg2015.entities.Term;
import com.pwufg2015.entities.Term;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "listTermBean")
@ViewScoped
public class ListTermBean extends MB {

    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;

    private transient DataModel<Term> model;

    private Term term = new Term();
    private List<Term> terms = new ArrayList<>();

    @PostConstruct
    public void init(){
        terms = termService.listAll();
    }

    public String editTerm() {

        flashContainer().put("term", model.getRowData());

        return "/admin/editTurma.xhtml?faces-redirect=true";

    }

    public void deleteTerm(){

        try {

            termService.deleteTerm(model.getRowData());
            terms.remove(model.getRowData());

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    //region Getter and Setter
    public DataModel<Term> getModel() {

        if (model == null) {
            model = new ListDataModel<>(terms);
        }

        return model;
    }


    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public void setModel(DataModel<Term> model) {
        this.model = model;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
    }

    public ITermBo getTermService() {
        return termService;
    }

    public void setTermService(ITermBo termService) {
        this.termService = termService;
    }
    //endregion

}
