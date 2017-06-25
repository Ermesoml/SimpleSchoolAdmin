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

@ManagedBean(name = "listCourseBean")
@ViewScoped
public class ListCourseBean extends MB {

    @ManagedProperty(name = "courseService", value = "#{CourseService}")
    private ICourseBo courseService;

    private transient DataModel<Course> model;

    private Course course = new Course();
    private List<Course> courses = new ArrayList<>();

    @PostConstruct
    public void init(){
        courses = courseService.listAll();
    }

    public String editCourse() {

        flashContainer().put("course", model.getRowData());

        return "/admin/editDisciplina.xhtml?faces-redirect=true";

    }

    public void deleteCourse(){

        try {

            courseService.deleteCourse(model.getRowData());
            courses.remove(model.getRowData());

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    //region Getter and Setter
    public DataModel<Course> getModel() {

        if (model == null) {
            model = new ListDataModel<>(courses);
        }

        return model;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setModel(DataModel<Course> model) {
        this.model = model;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public ICourseBo getCourseService() {
        return courseService;
    }

    public void setCourseService(ICourseBo courseService) {
        this.courseService = courseService;
    }
    //endregion

}
