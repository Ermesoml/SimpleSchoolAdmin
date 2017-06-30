package br.ufg.inf.bean.admin;

import br.ufg.inf.business.contracts.IStudentBo;
import br.ufg.inf.business.contracts.ITermBo;
import br.ufg.inf.entities.Student;
import br.ufg.inf.entities.Term;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Date;
import java.util.List;

/**
 * The Class PersistStudentBean.
 */
@ManagedBean(name = "persistStudentBean")
@ViewScoped
public class PersistStudentBean {

    /** The student service. */
    @ManagedProperty(name = "studentService", value = "#{StudentService}")
    private IStudentBo studentService;

    /** The term service. */
    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;

    /** The student. */
    private Student student = new Student();
    
    /** The term. */
    private Term term = new Term();


    /**
     * Persist new student.
     *
     * @return the string
     */
    public String persistNewStudent(){

        try {

            student.setAdmittanceDate(new Date());
            student.setStatus("Matriculado");
            student.setTermEnrolled(term);

            studentService.enrollStudent(student);

        }catch (Exception ex){

            ex.printStackTrace();
            return "";

        }

        return "/admin/gerAlunos.xhtml?faces-redirect=true";


    }

    /**
     * Gets the terms.
     *
     * @return the terms
     */
    public List<Term> getTerms(){
        return termService.listAll();
    }


    /**
     * Gets the student service.
     *
     * @return the student service
     */
    //region Getters and Setters
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
     * Gets the term service.
     *
     * @return the term service
     */
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

    //endregion

}
