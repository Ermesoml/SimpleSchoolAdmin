package com.csufg2016.bean.teacher;

import com.csufg2016.bean.MB;
import com.csufg2016.business.contracts.IAssignmentBo;
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

@ManagedBean(name = "teacherAssignmentsBean")
@ViewScoped
public class TeacherAssignmentsBean extends MB {

    @ManagedProperty(name = "assignmentService", value = "#{AssignmentService}")
    private IAssignmentBo assignmentService;

    private transient DataModel<Assignment> model;

    private Assignment assignment = new Assignment();
    private List<Assignment> assignments = new ArrayList<>();
    private TermCourses termCourse;

    @PostConstruct
    public void init() {
        termCourse = (TermCourses) flashContainer().get("termcourse");
        assignments = assignmentService.obtainByTermAndCourse(termCourse);
    }

    public String gerAssignment() {

        flashContainer().put("assignment", model.getRowData());
        return "/professor/gerAtividade.xhtml?faces-redirect=true";

    }

    public String newAssignment() {

        Assignment assignment = new Assignment();
        assignment.setTerm(termCourse);
        flashContainer().put("assignment", assignment);
        return "/professor/novaAtividade.xhtml?faces-redirect=true";

    }

    public String editAssignment(Assignment assignment) {
        flashContainer().put("assignment", assignment);
        return "/professor/editAtividade.xhtml?faces-redirect=true";

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
}
