package com.csufg2016.bean.admin;

import com.csufg2016.bean.MB;
import com.csufg2016.business.contracts.ICourseBo;
import com.csufg2016.entities.Course;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Objects;

@ManagedBean(name = "persistCourseBean")
@ViewScoped
public class PersistCourseBean extends MB {

    @ManagedProperty(name = "courseService", value = "#{CourseService}")
    private ICourseBo courseService;

    private Course course = new Course();

    @PostConstruct
    public void init() {
        course = (Course) flashContainer().get("course");

        if (Objects.isNull(course))
            course = new Course();
    }

    public String persistNewCourse(){

        try {

            courseService.newCourse(course);

        } catch (Exception ex) {

            ex.printStackTrace();
            return "";

        }

        return "/admin/gerDisciplinas.xhtml?faces-redirect=true";


    }

    public String editCourse() {

        try {

            courseService.edit(course);

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
