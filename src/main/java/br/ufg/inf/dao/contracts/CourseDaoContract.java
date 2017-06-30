package br.ufg.inf.dao.contracts;


import br.ufg.inf.entities.Course;
import br.ufg.inf.entities.TermCourses;

import java.util.List;

/**
 * The Interface CourseDaoContract.
 */
public interface CourseDaoContract extends GenericDaoContract<Course> {


    /**
     * Gets the term courses by teacher.
     *
     * @param teacherId the teacher id
     * @return the term courses by teacher
     */
    List<TermCourses> getTermCoursesByTeacher(Long teacherId);


}
