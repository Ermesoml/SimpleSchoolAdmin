package br.ufg.inf.bean.admin;

import br.ufg.inf.bean.MB;
import br.ufg.inf.business.contracts.IStudentBo;
import br.ufg.inf.entities.Student;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

/**
 * The Class ListStudentBean.
 */
@ManagedBean(name = "listStudentBean")
@ViewScoped
public class ListStudentBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8827969794774298534L;

	/** The student service. */
    @ManagedProperty(name = "studentService", value = "#{StudentService}")
    private IStudentBo studentService;

    /** The model. */
    private transient DataModel<Student> model;

    /** The student. */
    private Student student = new Student();
    
    /** The students. */
    private List<Student> students = new ArrayList<>();

    /**
     * Inits the.
     */
    @PostConstruct
    public void init(){
        students = studentService.listAll();
    }

    /**
     * Edits the student.
     *
     * @return the string
     */
    public String editStudent() {

        flashContainer().put("student", model.getRowData());

        return "/admin/editAluno.xhtml?faces-redirect=true";

    }

    /**
     * Delete student.
     */
    public void deleteStudent(){

        try {

            studentService.deleteStudent(model.getRowData());
            students.remove(model.getRowData());

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
    public DataModel<Student> getModel() {

        if (model == null) {
            model = new ListDataModel<>(students);
        }

        return model;
    }


    /**
     * Gets the student.
     *
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the student.
     *
     * @param student the new student
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    public void setModel(DataModel<Student> model) {
        this.model = model;
    }

    /**
     * Gets the students.
     *
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Sets the students.
     *
     * @param students the new students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
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
    //endregion

}
