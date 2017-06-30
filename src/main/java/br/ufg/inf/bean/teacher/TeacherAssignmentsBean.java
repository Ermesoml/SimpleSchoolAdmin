package br.ufg.inf.bean.teacher;

import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.IAssignmentBo;
import br.ufg.inf.entities.Assignment;
import br.ufg.inf.entities.TermCourses;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class TeacherAssignmentsBean.
 */
@ManagedBean(name = "teacherAssignmentsBean")
@ViewScoped
public class TeacherAssignmentsBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4379512197943655902L;

	/** The assignment service. */
    @ManagedProperty(name = "assignmentService", value = "#{AssignmentService}")
    private IAssignmentBo assignmentService;

    /** The model. */
    private transient DataModel<Assignment> model;

    /** The assignment. */
    private Assignment assignment = new Assignment();
    
    /** The assignments. */
    private List<Assignment> assignments = new ArrayList<>();
    
    /** The term course. */
    private TermCourses termCourse;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        termCourse = (TermCourses) flashContainer().get("termcourse");
        assignments = assignmentService.obtainByTermAndCourse(termCourse);
    }

    /**
     * Ger assignment.
     *
     * @return the string
     */
    public String gerAssignment() {

        flashContainer().put("assignment", model.getRowData());
        return "/professor/gerAtividade.xhtml?faces-redirect=true";

    }

    /**
     * New assignment.
     *
     * @return the string
     */
    public String newAssignment() {

        Assignment assignment = new Assignment();
        assignment.setTerm(termCourse);
        flashContainer().put("assignment", assignment);
        return "/professor/novaAtividade.xhtml?faces-redirect=true";

    }

    /**
     * Edits the assignment.
     *
     * @param assignment the assignment
     * @return the string
     */
    public String editAssignment(Assignment assignment) {
        flashContainer().put("assignment", assignment);
        return "/professor/editAtividade.xhtml?faces-redirect=true";

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
     * Gets the model.
     *
     * @return the model
     */
    public DataModel<Assignment> getModel() {

        if (model == null) {
            model = new ListDataModel<>(assignments);
        }

        return model;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    public void setModel(DataModel<Assignment> model) {
        this.model = model;
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

    /**
     * Gets the assignments.
     *
     * @return the assignments
     */
    public List<Assignment> getAssignments() {
        return assignments;
    }

    /**
     * Sets the assignments.
     *
     * @param assignments the new assignments
     */
    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }
}
