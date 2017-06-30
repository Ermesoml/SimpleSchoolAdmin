package br.ufg.inf.business.contracts;

import br.ufg.inf.entities.Assignment;
import br.ufg.inf.entities.TermCourses;

import java.util.List;

/**
 * The Interface IAssignmentBo.
 */
public interface IAssignmentBo extends BusinessContract<Assignment> {

    /**
     * Obtain by term and course.
     *
     * @param termCourse the term course
     * @return the list
     */
    List<Assignment> obtainByTermAndCourse(TermCourses termCourse);

    /**
     * Obtain by term.
     *
     * @param termId the term id
     * @return the list
     */
    List<Assignment> obtainByTerm(Long termId);

    /**
     * New assignment.
     *
     * @param assignment the assignment
     */
    void newAssignment(Assignment assignment);

}
