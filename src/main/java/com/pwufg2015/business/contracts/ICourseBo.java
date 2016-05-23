package com.pwufg2015.business.contracts;

import com.pwufg2015.entities.Course;

public interface ICourseBo extends BusinessContract<Course>{

    void newCourse(Course course);
    Course retrieveCourseById(long id);
    void updateCourse(Course course);
    void deleteCourse(Course course);

	
}
