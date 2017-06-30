package br.ufg.inf.bean.student;

import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.IStudentBo;
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
 * The Class StudentCoursesBean.
 */
@ManagedBean(name = "studentCoursesBean")
@ViewScoped
public class StudentCoursesBean extends MB {

    /** The student service. */
    @ManagedProperty(name = "studentService", value = "#{StudentService}")
    private IStudentBo studentService;

    /** The model. */
    private transient DataModel<TermCourses> model;

    /** The courses. */
    private List<TermCourses> courses = new ArrayList<>();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        courses = studentService.getEnrolledCourses(getUserService().getLoggedUser());
    }

    /**
     * Ger term assignments.
     *
     * @return the string
     */
    public String gerTermAssignments() {

        flashContainer().put("termcourse", model.getRowData());
        return "/aluno/gerAtividades.xhtml?faces-redirect=true";

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
     * Gets the student service.
     *
     * @return the student service
     */
    public IStudentBo getStudentService() {
        return studentService;
    }

    /**
     * Sets the student service.
     *
     * @param studentService the new student service
     */
    public void setStudentService(IStudentBo studentService) {
        this.studentService = studentService;
    }


}
