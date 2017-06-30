package br.ufg.inf.dao.contracts;

import br.ufg.inf.entities.Student;
import br.ufg.inf.entities.TermCourses;

import java.util.List;

/**
 * The Interface StudentDaoContract.
 */
public interface StudentDaoContract extends GenericDaoContract<Student> {

    /**
     * Gets the enrolled courses.
     *
     * @param termId the term id
     * @return the enrolled courses
     */
    List<TermCourses> getEnrolledCourses(Long termId);

}
