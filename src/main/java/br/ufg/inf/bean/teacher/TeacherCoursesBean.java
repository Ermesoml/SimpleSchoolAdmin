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

@ManagedBean(name = "teacherCoursesBean")
@ViewScoped
public class TeacherCoursesBean extends MB {

    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;

    private transient DataModel<TermCourses> model;

    private Teacher teacher = new Teacher();
    private List<TermCourses> courses = new ArrayList<>();

    @PostConstruct
    public void init(){
        courses = teacherService.retrieveTeacherCourses(getUserService().getLoggedUser());
    }

    public String gerTermAssignments() {

        flashContainer().put("termcourse", model.getRowData());
        return "/professor/gerAtividades.xhtml?faces-redirect=true";

    }

    //region Getter and Setter
    public DataModel<TermCourses> getModel() {

        if (model == null) {
            model = new ListDataModel<>(courses);
        }

        return model;
    }

    public void setModel(DataModel<TermCourses> model) {
        this.model = model;
    }

    public ITeacherBo getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(ITeacherBo teacherService) {
        this.teacherService = teacherService;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<TermCourses> getCourses() {
        return courses;
    }

    public void setCourses(List<TermCourses> courses) {
        this.courses = courses;
    }
}
