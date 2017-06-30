package br.ufg.inf.business.contracts;

import br.ufg.inf.entities.Student;
import br.ufg.inf.entities.TermCourses;

import java.util.List;

/**
 * The Interface IStudentBo.
 */
public interface IStudentBo extends BusinessContract<Student>{

    /**
     * Delete student.
     *
     * @param student the student
     */
    void deleteStudent(Student student);
    
    /**
     * Retrieve student by id.
     *
     * @param id the id
     * @return the student
     */
    Student retrieveStudentById(long id);
    
    /**
     * Update student.
     *
     * @param student the student
     */
    void updateStudent(Student student);
    
    /**
     * Enroll student.
     *
     * @param student the student
     */
    void enrollStudent(Student student);

    /**
     * Gets the enrolled courses.
     *
     * @param studentId the student id
     * @return the enrolled courses
     */
    List<TermCourses> getEnrolledCourses(Long studentId);

}
