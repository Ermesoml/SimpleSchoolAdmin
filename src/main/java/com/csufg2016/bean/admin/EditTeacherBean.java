package com.csufg2016.bean.admin;

import com.csufg2016.bean.MB;
import com.csufg2016.business.contracts.ITeacherBo;
import com.csufg2016.entities.Teacher;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "editTeacherBean")
@RequestScoped
public class EditTeacherBean extends MB {

    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;

    private Teacher teacher = new Teacher();

    @PostConstruct
    public void init() {

        teacher = (Teacher) flashContainer().get("teacher");

    }

    public String editTeacher() {

        try {
            teacherService.updateTeacher(teacher);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

        return "/admin/gerProfessores.xhtml?faces-redirect=true";
    }

    //region Getters and Setters
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ITeacherBo getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(ITeacherBo teacherService) {
        this.teacherService = teacherService;
    }
    //endregion
}
