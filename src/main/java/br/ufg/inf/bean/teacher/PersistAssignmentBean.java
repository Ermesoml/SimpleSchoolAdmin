package br.ufg.inf.bean.teacher;


import br.ufg.inf.entities.Assignment;
import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.IAssignmentBo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Date;

/**
 * Controlador da tela de tarefas
 * 
 * @author ygors
 */
@ManagedBean(name = "persistAssignmentBean")
@ViewScoped
public class PersistAssignmentBean extends MB {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2983446353474472898L;

	/** The assignment service. */
	@ManagedProperty(name = "assignmentService", value = "#{AssignmentService}")
    private IAssignmentBo assignmentService;

    /** The assignment. */
    private Assignment assignment = new Assignment();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        assignment = (Assignment) flashContainer().get("assignment");
    }

    /**
     * Persist new assignment.
     *
     * @return the string
     */
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

    /**
     * Delete assignment.
     *
     * @param assignment the assignment
     */
    public void deleteAssignment(Assignment assignment) {

        try {
            assignmentService.delete(assignment);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Edits the assignment.
     *
     * @return the string
     */
    public String editAssignment() {

        try {
            assignmentService.edit(assignment);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

        return "/professor/gerDisciplinas.xhtml?faces-redirect=true";

    }

    /**
     * Gets the assignment service.
     *
     * @return the assignment service
     */
    public IAssignmentBo getAssignmentService() {
        return assignmentService;
    }

    /**
     * Sets the assignment service.
     *
     * @param assignmentService the new assignment service
     */
    public void setAssignmentService(IAssignmentBo assignmentService) {
        this.assignmentService = assignmentService;
    }

    /**
     * Gets the assignment.
     *
     * @return the assignment
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     * Sets the assignment.
     *
     * @param assignment the new assignment
     */
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }
}
