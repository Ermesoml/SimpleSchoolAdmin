package br.ufg.inf.bean.admin;


import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ITeacherBo;
import br.ufg.inf.entities.Teacher;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Date;

@ManagedBean(name = "persistTeacherBean")
@ViewScoped
public class PersistTeacherBean extends MB {

    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;

    private Teacher teacher = new Teacher();

    public String persistNewTeacher(){

        try {

            teacher.setAdmittanceDate(new Date());
            teacher.setActive(true);
            teacherService.newTeacher(teacher);

        }catch (Exception ex){

            ex.printStackTrace();
            return "";

        }

        return "/admin/gerProfessores.xhtml?faces-redirect=true";


    }



    //region Getters and Setters
    public ITeacherBo getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(ITeacherBo teacherService) {
        this.teacherService = teacherService;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    //endregion
}
