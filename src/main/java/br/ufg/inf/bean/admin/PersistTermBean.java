package br.ufg.inf.bean.admin;


import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.ufg.inf.Utils.Pair;
import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ICourseBo;
import br.ufg.inf.business.contracts.ITeacherBo;
import br.ufg.inf.business.contracts.ITermBo;
import br.ufg.inf.entities.Course;
import br.ufg.inf.entities.Teacher;
import br.ufg.inf.entities.Term;

/**
 * The Class PersistTermBean.
 */
@ViewScoped
public class PersistTermBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1671602889753933350L;

	/** The term service. */
    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;

    /** The teacher service. */
    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;

    /** The course service. */
    @ManagedProperty(name = "courseService", value = "#{CourseService}")
    private ICourseBo courseService;

    /** The term. */
    private Term term = new Term();
    
    /** The course list. */
    private List<Pair<Course,Teacher>> courseList = new ArrayList<>();

    /**
     * Persist new term.
     *
     * @return the string
     */
    public String persistNewTerm(){

        try {

            termService.newTerm(term, courseList);

        }catch (Exception ex){

            ex.printStackTrace();
            return "";

        }

        return "/admin/gerTurmas.xhtml?faces-redirect=true";

    }

    /**
     * Gets the teachers.
     *
     * @return the teachers
     */
    public List<Teacher> getTeachers(){

        return teacherService.listAll();

    }

    /**
     * Gets the courses.
     *
     * @return the courses
     */
    public List<Course> getCourses(){

        return courseService.listAll();

    }

    /**
     * Gets the course list.
     *
     * @return the course list
     */
    public List<Pair<Course, Teacher>> getCourseList() {
        return courseList;
    }

    /**
     * Adds the course.
     */
    public void addCourse() {
        courseList.add(new Pair<>(new Course(), new Teacher()));
    }

    /**
     * Sets the course list.
     *
     * @param courseList the course list
     */
    public void setCourseList(List<Pair<Course, Teacher>> courseList) {
        this.courseList = courseList;
    }

    /**
     * Gets the term service.
     *
     * @return the term service
     */
    //region Getters and Setters
    public ITermBo getTermService() {
        return termService;
    }

    /**
     * Sets the term service.
     *
     * @param termService the new term service
     */
    public void setTermService(ITermBo termService) {
        this.termService = termService;
    }

    /**
     * Gets the term.
     *
     * @return the term
     */
    public Term getTerm() {
        return term;
    }

    /**
     * Sets the term.
     *
     * @param term the new term
     */
    public void setTerm(Term term) {
        this.term = term;
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
