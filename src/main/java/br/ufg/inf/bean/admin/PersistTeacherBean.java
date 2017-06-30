package br.ufg.inf.bean.admin;


import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ITeacherBo;
import br.ufg.inf.entities.Teacher;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Date;

/**
 * The Class PersistTeacherBean.
 */
@ManagedBean(name = "persistTeacherBean")
@ViewScoped
public class PersistTeacherBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2252727737865280725L;

	/** The teacher service. */
    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;

    /** The teacher. */
    private Teacher teacher = new Teacher();

    /**
     * Persist new teacher.
     *
     * @return the string
     */
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



    /**
     * Gets the teacher service.
     *
     * @return the teacher service
     */
    //region Getters and Setters
    public ITeacherBo getTeacherService() {
        return teacherService;
    }

    /**
     * Sets the teacher service.
     *
     * @param teacherService the new teacher service
     */
    public void setTeacherService(ITeacherBo teacherService) {
        this.teacherService = teacherService;
    }

    /**
     * Gets the teacher.
     *
     * @return the teacher
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Sets the teacher.
     *
     * @param teacher the new teacher
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    //endregion
}
