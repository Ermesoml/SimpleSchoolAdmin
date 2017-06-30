package br.ufg.inf.bean.admin;

import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ITeacherBo;
import br.ufg.inf.entities.Teacher;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 * The Class EditTeacherBean.
 */
@ManagedBean(name = "editTeacherBean")
@RequestScoped
public class EditTeacherBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6231549516122203504L;

	/** The teacher service. */
    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;

    /** The teacher. */
    private Teacher teacher = new Teacher();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {

        teacher = (Teacher) flashContainer().get("teacher");

    }

    /**
     * Edits the teacher.
     *
     * @return the string
     */
    public String editTeacher() {

        try {
            teacherService.updateTeacher(teacher);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }

        return "/admin/gerProfessores.xhtml?faces-redirect=true";
    }

    /**
     * Gets the teacher.
     *
     * @return the teacher
     */
    //region Getters and Setters
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

    /**
     * Gets the teacher service.
     *
     * @return the teacher service
     */
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
    //endregion
}
