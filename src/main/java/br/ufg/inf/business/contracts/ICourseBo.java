package br.ufg.inf.business.contracts;

import br.ufg.inf.entities.Course;

public interface ICourseBo extends BusinessContract<Course>{

    void newCourse(Course course);
    Course retrieveCourseById(long id);
    void updateCourse(Course course);
    void deleteCourse(Course course);

	
}
