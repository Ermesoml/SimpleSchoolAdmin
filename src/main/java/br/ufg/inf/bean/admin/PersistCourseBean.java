package br.ufg.inf.bean.admin;

import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ICourseBo;
import br.ufg.inf.entities.Course;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Objects;

/**
 * The Class PersistCourseBean.
 */
@ManagedBean(name = "persistCourseBean")
@ViewScoped
public class PersistCourseBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5908662552077189463L;

	/** The course service. */
    @ManagedProperty(name = "courseService", value = "#{CourseService}")
    private ICourseBo courseService;

    /** The course. */
    private Course course = new Course();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        course = (Course) flashContainer().get("course");

        if (Objects.isNull(course))
            course = new Course();
    }

    /**
     * Persist new course.
     *
     * @return the string
     */
    public String persistNewCourse(){

        try {

            courseService.newCourse(course);

        } catch (Exception ex) {

            ex.printStackTrace();
            return "";

        }

        return "/admin/gerDisciplinas.xhtml?faces-redirect=true";


    }

    /**
     * Edits the course.
     *
     * @return the string
     */
    public String editCourse() {

        try {

            courseService.edit(course);

        }catch (Exception ex){

            ex.printStackTrace();
            return "";

        }

        return "/admin/gerDisciplinas.xhtml?faces-redirect=true";


    }



    /**
     * Gets the course service.
     *
     * @return the course service
     */
    //region Getters and Setters
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
    //endregion

}
