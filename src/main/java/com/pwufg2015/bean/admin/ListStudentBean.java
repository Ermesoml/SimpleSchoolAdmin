package com.pwufg2015.bean.admin;

import com.pwufg2015.bean.MB;
import com.pwufg2015.business.contracts.IStudentBo;
import com.pwufg2015.entities.Student;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "listStudentBean")
@ViewScoped
public class ListStudentBean extends MB {

    @ManagedProperty(name = "studentService", value = "#{StudentService}")
    private IStudentBo studentService;

    private transient DataModel<Student> model;

    private Student student = new Student();
    private List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init(){
        students = studentService.listAll();
    }

    public String editStudent() {

        flashContainer().put("student", model.getRowData());

        return "/admin/editAluno.xhtml?faces-redirect=true";

    }

    public void deleteStudent(){

        try {

            studentService.deleteStudent(model.getRowData());
            students.remove(model.getRowData());

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    //region Getter and Setter
    public DataModel<Student> getModel() {

        if (model == null) {
            model = new ListDataModel<>(students);
        }

        return model;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setModel(DataModel<Student> model) {
        this.model = model;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public IStudentBo getStudentService() {
        return studentService;
    }

    public void setStudentService(IStudentBo studentService) {
        this.studentService = studentService;
    }
    //endregion

}
