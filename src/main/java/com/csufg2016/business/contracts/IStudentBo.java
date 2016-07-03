package com.csufg2016.business.contracts;

import com.csufg2016.entities.Student;

public interface IStudentBo extends BusinessContract<Student>{

    void deleteStudent(Student student);
    Student retrieveStudentById(long id);
    void updateStudent(Student student);
    void enrollStudent(Student student);

}
