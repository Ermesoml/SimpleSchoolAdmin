package com.csufg2016.dao.contracts;


import com.csufg2016.entities.Course;
import com.csufg2016.entities.TermCourses;

import java.util.List;

public interface CourseDaoContract extends GenericDaoContract<Course> {


    List<TermCourses> getTermCoursesByTeacher(Long teacherId);


}
