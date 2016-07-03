package com.csufg2016.bean.admin;

import com.csufg2016.business.contracts.IStudentBo;
import com.csufg2016.business.contracts.ITermBo;
import com.csufg2016.entities.Student;
import com.csufg2016.entities.Term;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Date;
import java.util.List;

@ManagedBean(name = "persistStudentBean")
@ViewScoped
public class PersistStudentBean {

    @ManagedProperty(name = "studentService", value = "#{StudentService}")
    private IStudentBo studentService;

    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;

    private Student student = new Student();
    private Term term = new Term();


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

    public List<Term> getTerms(){
        return termService.listAll();
    }


    //region Getters and Setters
    public IStudentBo getStudentService() {
        return studentService;
    }

    public void setStudentService(IStudentBo studentService) {
        this.studentService = studentService;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

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

    //endregion

}
