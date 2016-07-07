package com.csufg2016.dao.contracts;

import com.csufg2016.entities.Student;
import com.csufg2016.entities.TermCourses;

import java.util.List;

public interface StudentDaoContract extends GenericDaoContract<Student> {

    List<TermCourses> getEnrolledCourses(Long termId);

}
