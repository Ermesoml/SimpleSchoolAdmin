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

@ManagedBean(name = "editTermBean")
@RequestScoped
public class EditTermBean extends MB {

    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;

    private transient DataModel<TermCourses> model;
    private Term term = new Term();

    @PostConstruct
    public void init(){
        term = (Term) flashContainer().get("term");
    }

    public String editTerm(){

        try{
            termService.updateTerm(term);
        }catch (Exception ex){
            ex.printStackTrace();
            return "";
        }

        return "/admin/gerTurmas.xhtml?faces-redirect=true";
    }

    public DataModel<TermCourses> getModel() {

        List<TermCourses> courses = new ArrayList<>();
        courses.addAll(term.getTermCourses());

        if (model == null) {
            model = new ListDataModel<>(courses);
        }

        return model;
    }

    //region Getters and Setters
    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public ITermBo getTermService() {
        return termService;
    }

    public void setTermService(ITermBo termService) {
        this.termService = termService;
    }
    //endregion


}
