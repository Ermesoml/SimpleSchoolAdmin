package br.ufg.inf.dao.contracts;

import br.ufg.inf.entities.Student;
import br.ufg.inf.entities.TermCourses;

import java.util.List;

public interface StudentDaoContract extends GenericDaoContract<Student> {

    List<TermCourses> getEnrolledCourses(Long termId);

}
