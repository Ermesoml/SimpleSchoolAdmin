package br.ufg.inf.bean.student;

import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.IAssignmentBo;
import br.ufg.inf.business.contracts.IStudentBo;
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
import java.util.Objects;

/**
 * The Class StudentAssignmentsBean.
 */
@ManagedBean(name = "studentAssignmentsBean")
@ViewScoped
public class StudentAssignmentsBean extends MB {

    /** The assignment service. */
    @ManagedProperty(name = "assignmentService", value = "#{AssignmentService}")
    private IAssignmentBo assignmentService;

    /** The student service. */
    @ManagedProperty(name = "studentService", value = "#{StudentService}")
    private IStudentBo studentService;


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

        if (Objects.isNull(termCourse)) {
            assignments = assignmentService.obtainByTerm(studentService.retrieveStudentById(getUserService()
                    .getLoggedUser()).getTermEnrolled().getTermId());
        } else {
            assignments = assignmentService.obtainByTermAndCourse(termCourse);
        }
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

    /**
     * Gets the student service.
     *
     * @return the student service
     */
    public IStudentBo getStudentService() {
        return studentService;
    }

    /**
     * Sets the student service.
     *
     * @param studentService the new student service
     */
    public void setStudentService(IStudentBo studentService) {
        this.studentService = studentService;
    }

    /**
     * Gets the term course.
     *
     * @return the term course
     */
    public TermCourses getTermCourse() {
        return termCourse;
    }

    /**
     * Sets the term course.
     *
     * @param termCourse the new term course
     */
    public void setTermCourse(TermCourses termCourse) {
        this.termCourse = termCourse;
    }
}
