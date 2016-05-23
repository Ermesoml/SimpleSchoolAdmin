package com.pwufg2015.bean.admin;

import com.pwufg2015.bean.MB;
import com.pwufg2015.business.contracts.ICourseBo;
import com.pwufg2015.entities.Course;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Date;

@ManagedBean(name = "persistCourseBean")
@ViewScoped
public class PersistCourseBean extends MB {

    @ManagedProperty(name = "courseService", value = "#{CourseService}")
    private ICourseBo courseService;

    private Course course = new Course();

    public String persistNewCourse(){

        try {

            courseService.newCourse(course);

        }catch (Exception ex){

            ex.printStackTrace();
            return "";

        }

        return "/admin/gerDisciplinas.xhtml?faces-redirect=true";


    }



    //region Getters and Setters
    public ICourseBo getCourseService() {
        return courseService;
    }

    public void setCourseService(ICourseBo courseService) {
        this.courseService = courseService;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    //endregion

}
