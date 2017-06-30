package br.ufg.inf.dao.contracts;

import br.ufg.inf.entities.Assignment;

import java.util.List;

/**
 * The Interface AssignmentDaoContract.
 */
public interface AssignmentDaoContract extends GenericDaoContract<Assignment> {

    /**
     * Obtain by term and course.
     *
     * @param termId the term id
     * @param courseId the course id
     * @return the list
     */
    List<Assignment> obtainByTermAndCourse(Long termId, Long courseId);

}
