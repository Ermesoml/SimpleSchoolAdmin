package com.csufg2016.bean.admin;

import com.csufg2016.bean.MB;
import com.csufg2016.business.contracts.IStudentBo;
import com.csufg2016.business.contracts.ITermBo;
import com.csufg2016.entities.Student;
import com.csufg2016.entities.Term;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "editStudentBean")
@RequestScoped
public class EditStudentBean extends MB {

    @ManagedProperty(name = "studentService", value = "#{StudentService}")
    private IStudentBo studentService;

    @ManagedProperty(name = "termService", value = "#{TermService}")
    private ITermBo termService;

    private Student student = new Student();
    private Term term = new Term();

    @PostConstruct
    public void init(){

        student = (Student) flashContainer().get("student");

    }

    public String editStudent(){

        try{
            studentService.updateStudent(student);
        }catch (Exception ex){
            ex.printStackTrace();
            return "";
        }

        return "/admin/gerAlunos.xhtml?faces-redirect=true";
    }

    //region Getters and Setters
    public Student getStudent() {
        return student;
    }

    public List<Term> getTerms(){
        return termService.listAll();
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public IStudentBo getStudentService() {
        return studentService;
    }

    public void setStudentService(IStudentBo studentService) {
        this.studentService = studentService;
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
