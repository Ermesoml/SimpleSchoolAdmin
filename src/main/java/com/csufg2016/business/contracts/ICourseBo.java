package com.csufg2016.business.contracts;

import com.csufg2016.entities.Course;

public interface ICourseBo extends BusinessContract<Course>{

    void newCourse(Course course);
    Course retrieveCourseById(long id);
    void updateCourse(Course course);
    void deleteCourse(Course course);

	
}
