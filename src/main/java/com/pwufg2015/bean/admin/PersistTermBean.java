package com.pwufg2015.bean.admin;


import com.pwufg2015.Utils.Pair;
import com.pwufg2015.bean.MB;
import com.pwufg2015.business.contracts.ICourseBo;
import com.pwufg2015.business.contracts.ITeacherBo;
import com.pwufg2015.business.contracts.ITermBo;
import com.pwufg2015.entities.Course;
import com.pwufg2015.entities.Teacher;
import com.pwufg2015.entities.Term;

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
