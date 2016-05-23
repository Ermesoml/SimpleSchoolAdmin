package com.pwufg2015.business.contracts;

import com.pwufg2015.entities.Student;
import com.pwufg2015.entities.Term;

public interface IStudentBo extends BusinessContract<Student>{

    void deleteStudent(Student student);
    Student retrieveStudentById(long id);
    void updateStudent(Student student);
    void enrollStudent(Student student);

}
