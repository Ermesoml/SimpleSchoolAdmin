package br.ufg.inf.dao.contracts;


import br.ufg.inf.entities.Course;
import br.ufg.inf.entities.TermCourses;

import java.util.List;

public interface CourseDaoContract extends GenericDaoContract<Course> {


    List<TermCourses> getTermCoursesByTeacher(Long teacherId);


}
