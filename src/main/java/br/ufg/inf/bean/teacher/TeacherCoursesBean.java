package br.ufg.inf.bean.teacher;

import br.ufg.inf.entities.Teacher;
import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ITeacherBo;
import br.ufg.inf.entities.TermCourses;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class TeacherCoursesBean.
 */
@ManagedBean(name = "teacherCoursesBean")
@ViewScoped
public class TeacherCoursesBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8409973854502953468L;

	/** The teacher service. */
    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;

    /** The model. */
    private transient DataModel<TermCourses> model;

    /** The teacher. */
    private Teacher teacher = new Teacher();
    
    /** The courses. */
    private List<TermCourses> courses = new ArrayList<>();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init(){
        courses = teacherService.retrieveTeacherCourses(getUserService().getLoggedUser());
    }

    /**
     * Ger term assignments.
     *
     * @return the string
     */
    public String gerTermAssignments() {

        flashContainer().put("termcourse", model.getRowData());
        return "/professor/gerAtividades.xhtml?faces-redirect=true";

    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    //region Getter and Setter
    public DataModel<TermCourses> getModel() {

        if (model == null) {
            model = new ListDataModel<>(courses);
        }

        return model;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    public void setModel(DataModel<TermCourses> model) {
        this.model = model;
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
     * Gets the courses.
     *
     * @return the courses
     */
    public List<TermCourses> getCourses() {
        return courses;
    }

    /**
     * Sets the courses.
     *
     * @param courses the new courses
     */
    public void setCourses(List<TermCourses> courses) {
        this.courses = courses;
    }
}
