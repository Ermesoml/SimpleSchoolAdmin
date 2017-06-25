package br.ufg.inf.business.contracts;

import br.ufg.inf.entities.Student;
import br.ufg.inf.entities.TermCourses;

import java.util.List;

public interface IStudentBo extends BusinessContract<Student>{

    void deleteStudent(Student student);
    Student retrieveStudentById(long id);
    void updateStudent(Student student);
    void enrollStudent(Student student);

    List<TermCourses> getEnrolledCourses(Long studentId);

}
