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
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "teacherAssignmentsBean")
@ViewScoped
public class TeacherAssignmentsBean extends MB {

    @ManagedProperty(name = "assignmentService", value = "#{AssignmentService}")
    private IAssignmentBo assignmentService;

    private transient DataModel<TermCourses> model;

    private Assignment assignment = new Assignment();
    private List<Assignment> assignments = new ArrayList<>();

    @PostConstruct
    public void init(){

    }

    public IAssignmentBo getAssignmentService() {
        return assignmentService;
    }

    public void setAssignmentService(IAssignmentBo assignmentService) {
        this.assignmentService = assignmentService;
    }

    public DataModel<TermCourses> getModel() {
        return model;
    }

    public void setModel(DataModel<TermCourses> model) {
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
