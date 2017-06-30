package br.ufg.inf.bean.admin;

import br.ufg.inf.entities.Teacher;
import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ITeacherBo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class ListTeacherBean.
 */
@ManagedBean(name = "listTeacherBean")
@ViewScoped
public class ListTeacherBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = 308903458976561610L;

	/** The teacher service. */
    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;

    /** The model. */
    private transient DataModel<Teacher> model;

    /** The teacher. */
    private Teacher teacher = new Teacher();
    
    /** The teachers. */
    private List<Teacher> teachers = new ArrayList<>();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init(){
         teachers = teacherService.listAll();
    }

    /**
     * Edits the teacher.
     *
     * @return the string
     */
    public String editTeacher() {

        flashContainer().put("teacher", model.getRowData());

        return "/admin/editProfessor.xhtml?faces-redirect=true";

    }

    /**
     * Delete teacher.
     */
    public void deleteTeacher(){

        try {

         teacherService.deleteTeacher(model.getRowData());
         teachers.remove(model.getRowData());

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
    
    /**
     * Show status.
     *
     * @param t the t
     * @return the string
     */
    public String showStatus(Teacher t) {
    	if (t.getActive()) {
    		return "Ativo";
    	}
    	return "Inativo";
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    //region Getter and Setter
    public DataModel<Teacher> getModel() {

        if (model == null) {
            model = new ListDataModel<>(teachers);
        }

        return model;
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

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    public void setModel(DataModel<Teacher> model) {
        this.model = model;
    }

    /**
     * Gets the teachers.
     *
     * @return the teachers
     */
    public List<Teacher> getTeachers() {
        return teachers;
    }

    /**
     * Sets the teachers.
     *
     * @param teachers the new teachers
     */
    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
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
