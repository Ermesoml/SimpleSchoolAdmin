package com.csufg2016.bean.student;

import com.csufg2016.bean.MB;
import com.csufg2016.business.contracts.IStudentBo;
import com.csufg2016.entities.TermCourses;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "studentCoursesBean")
@ViewScoped
public class StudentCoursesBean extends MB {

    @ManagedProperty(name = "studentService", value = "#{StudentService}")
    private IStudentBo studentService;

    private transient DataModel<TermCourses> model;

    private List<TermCourses> courses = new ArrayList<>();

    @PostConstruct
    public void init() {
        courses = studentService.getEnrolledCourses(getUserService().getLoggedUser());
    }

    public String gerTermAssignments() {

        flashContainer().put("termcourse", model.getRowData());
        return "/aluno/gerAtividades.xhtml?faces-redirect=true";

    }

    //region Getter and Setter
    public DataModel<TermCourses> getModel() {

        if (model == null) {
            model = new ListDataModel<>(courses);
        }

        return model;
    }

    public void setModel(DataModel<TermCourses> model) {
        this.model = model;
    }

    public IStudentBo getStudentService() {
        return studentService;
    }

    public void setStudentService(IStudentBo studentService) {
        this.studentService = studentService;
    }


}
