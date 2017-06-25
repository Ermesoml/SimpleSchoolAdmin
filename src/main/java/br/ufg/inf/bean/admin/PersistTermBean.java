package br.ufg.inf.bean.admin;


import br.ufg.inf.Utils.Pair;
import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.ICourseBo;
import br.ufg.inf.business.contracts.ITeacherBo;
import br.ufg.inf.business.contracts.ITermBo;
import br.ufg.inf.entities.Teacher;
import br.ufg.inf.entities.Term;
import br.ufg.inf.entities.Course;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "persistTermBean")
@ViewScoped
public class PersistTermBean extends MB {

    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;

    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;

    @ManagedProperty(name = "courseService", value = "#{CourseService}")
    private ICourseBo courseService;

    private Term term = new Term();
    private List<Pair<Course,Teacher>> courseList = new ArrayList<>();

    public String persistNewTerm(){

        try {

            termService.newTerm(term, courseList);

        }catch (Exception ex){

            ex.printStackTrace();
            return "";

        }

        return "/admin/gerTurmas.xhtml?faces-redirect=true";

    }

    public List<Teacher> getTeachers(){

        return teacherService.listAll();

    }

    public List<Course> getCourses(){

        return courseService.listAll();

    }

    public List<Pair<Course, Teacher>> getCourseList() {
        return courseList;
    }

    public void addCourse() {
        courseList.add(new Pair<>(new Course(), new Teacher()));
    }

    public void setCourseList(List<Pair<Course, Teacher>> courseList) {
        this.courseList = courseList;
    }

    //region Getters and Setters
    public ITermBo getTermService() {
        return termService;
    }

    public void setTermService(ITermBo termService) {
        this.termService = termService;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public ITeacherBo getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(ITeacherBo teacherService) {
        this.teacherService = teacherService;
    }

    public ICourseBo getCourseService() {
        return courseService;
    }

    public void setCourseService(ICourseBo courseService) {
        this.courseService = courseService;
    }

    //endregion
}
