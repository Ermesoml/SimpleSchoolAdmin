package com.csufg2016.bean.student;

import com.csufg2016.bean.MB;
import com.csufg2016.business.contracts.IAssignmentBo;
import com.csufg2016.business.contracts.IStudentBo;
import com.csufg2016.entities.Assignment;
import com.csufg2016.entities.TermCourses;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@ManagedBean(name = "studentAssignmentsBean")
@ViewScoped
public class StudentAssignmentsBean extends MB {

    @ManagedProperty(name = "assignmentService", value = "#{AssignmentService}")
    private IAssignmentBo assignmentService;

    @ManagedProperty(name = "studentService", value = "#{StudentService}")
    private IStudentBo studentService;


    private transient DataModel<Assignment> model;

    private Assignment assignment = new Assignment();
    private List<Assignment> assignments = new ArrayList<>();
    private TermCourses termCourse;

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

    public IAssignmentBo getAssignmentService() {
        return assignmentService;
    }

    public void setAssignmentService(IAssignmentBo assignmentService) {
        this.assignmentService = assignmentService;
    }

    public DataModel<Assignment> getModel() {

        if (model == null) {
            model = new ListDataModel<>(assignments);
        }

        return model;
    }

    public void setModel(DataModel<Assignment> model) {
        this.model = model;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public IStudentBo getStudentService() {
        return studentService;
    }

    public void setStudentService(IStudentBo studentService) {
        this.studentService = studentService;
    }

    public TermCourses getTermCourse() {
        return termCourse;
    }

    public void setTermCourse(TermCourses termCourse) {
        this.termCourse = termCourse;
    }
}
