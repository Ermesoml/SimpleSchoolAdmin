package br.ufg.inf.bean.teacher;


import br.ufg.inf.entities.Assignment;
import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.IAssignmentBo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Date;

@ManagedBean(name = "persistAssignmentBean")
@ViewScoped
public class PersistAssignmentBean extends MB {

    @ManagedProperty(name = "assignmentService", value = "#{AssignmentService}")
    private IAssignmentBo assignmentService;

    private Assignment assignment = new Assignment();

    @PostConstruct
    public void init() {
        assignment = (Assignment) flashContainer().get("assignment");
    }

    public String persistNewAssignment() {


        try {

            assignment.setCreateDate(new Date());
            assignmentService.newAssignment(assignment);

        } catch (Exception ex) {

            ex.printStackTrace();
            return "";

        }

        return "/professor/gerDisciplinas.xhtml?faces-redirect=true";

    }

    public void deleteAssignment(Assignment assignment) {

        try {
            assignmentService.delete(assignment);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String editAssignment() {

        try {
            assignmentService.edit(assignment);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

        return "/professor/gerDisciplinas.xhtml?faces-redirect=true";

    }

    public IAssignmentBo getAssignmentService() {
        return assignmentService;
    }

    public void setAssignmentService(IAssignmentBo assignmentService) {
        this.assignmentService = assignmentService;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
