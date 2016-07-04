package com.csufg2016.bean.teacher;

import com.csufg2016.bean.MB;
import com.csufg2016.business.contracts.ITeacherBo;
import com.csufg2016.entities.Teacher;
import com.csufg2016.entities.TermCourses;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "manageAssignmentsBean")
@ViewScoped
public class ManageAssignmentsBean extends MB {

    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;

    private transient DataModel<TermCourses> model;

    private Teacher teacher = new Teacher();
    private List<TermCourses> courses = new ArrayList<>();

    @PostConstruct
    public void init(){
        courses = teacherService.retrieveTeacherCourses(getUserService().getLoggedUser().getUser().getPersonId());
    }

    //region Getter and Setter
    public DataModel<TermCourses> getModel() {

        if (model == null) {
            model = new ListDataModel<>(courses);
        }

        return model;
    }

    public ITeacherBo getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(ITeacherBo teacherService) {
        this.teacherService = teacherService;
    }

    public void setModel(DataModel<TermCourses> model) {
        this.model = model;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<TermCourses> getCourses() {
        return courses;
    }

    public void setCourses(List<TermCourses> courses) {
        this.courses = courses;
    }
}
