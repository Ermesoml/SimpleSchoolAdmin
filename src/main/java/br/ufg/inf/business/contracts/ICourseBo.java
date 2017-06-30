package br.ufg.inf.business.contracts;

import br.ufg.inf.entities.Course;

/**
 * The Interface ICourseBo.
 */
public interface ICourseBo extends BusinessContract<Course>{

    /**
     * New course.
     *
     * @param course the course
     */
    void newCourse(Course course);
    
    /**
     * Retrieve course by id.
     *
     * @param id the id
     * @return the course
     */
    Course retrieveCourseById(long id);
    
    /**
     * Update course.
     *
     * @param course the course
     */
    void updateCourse(Course course);
    
    /**
     * Delete course.
     *
     * @param course the course
     */
    void deleteCourse(Course course);

	
}
