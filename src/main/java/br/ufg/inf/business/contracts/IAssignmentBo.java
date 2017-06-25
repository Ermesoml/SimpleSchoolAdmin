package br.ufg.inf.business.contracts;

import br.ufg.inf.entities.Assignment;
import br.ufg.inf.entities.TermCourses;

import java.util.List;

public interface IAssignmentBo extends BusinessContract<Assignment> {

    List<Assignment> obtainByTermAndCourse(TermCourses termCourse);

    List<Assignment> obtainByTerm(Long termId);

    void newAssignment(Assignment assignment);

}
