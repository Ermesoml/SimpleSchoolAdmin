package br.ufg.inf.dao.contracts;

import br.ufg.inf.entities.Assignment;

import java.util.List;

public interface AssignmentDaoContract extends GenericDaoContract<Assignment> {

    List<Assignment> obtainByTermAndCourse(Long termId, Long courseId);

}
