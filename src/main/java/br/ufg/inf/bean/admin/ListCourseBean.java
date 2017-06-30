package br.ufg.inf.bean.admin;

import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ICourseBo;
import br.ufg.inf.entities.Course;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class ListCourseBean.
 */
@ManagedBean(name = "listCourseBean")
@ViewScoped
public class ListCourseBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5979888829842994241L;

	/** The course service. */
    @ManagedProperty(name = "courseService", value = "#{CourseService}")
    private ICourseBo courseService;

    /** The model. */
    private transient DataModel<Course> model;

    /** The course. */
    private Course course = new Course();
    
    /** The courses. */
    private List<Course> courses = new ArrayList<>();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init(){
        courses = courseService.listAll();
    }

    /**
     * Edits the course.
     *
     * @return the string
     */
    public String editCourse() {

        flashContainer().put("course", model.getRowData());

        return "/admin/editDisciplina.xhtml?faces-redirect=true";

    }

    /**
     * Delete course.
     */
    public void deleteCourse(){

        try {

            courseService.deleteCourse(model.getRowData());
            courses.remove(model.getRowData());

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    //region Getter and Setter
    public DataModel<Course> getModel() {

        if (model == null) {
            model = new ListDataModel<>(courses);
        }

        return model;
    }


    /**
     * Gets the course.
     *
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Sets the course.
     *
     * @param course the new course
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    public void setModel(DataModel<Course> model) {
        this.model = model;
    }

    /**
     * Gets the courses.
     *
     * @return the courses
     */
    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Sets the courses.
     *
     * @param courses the new courses
     */
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    /**
     * Gets the course service.
     *
     * @return the course service
     */
    public ICourseBo getCourseService() {
        return courseService;
    }

    /**
     * Sets the course service.
     *
     * @param courseService the new course service
     */
    public void setCourseService(ICourseBo courseService) {
        this.courseService = courseService;
    }
    //endregion

}
