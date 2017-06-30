package br.ufg.inf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Class Course.
 */
@Entity
@Table(name = "Courses")
public class Course implements Serializable {

    /** The course id. */
    private Long courseId;
    
    /** The course name. */
    private String courseName;
    
    /** The term courses. */
    private Set<TermCourses> termCourses = new HashSet<>(0);
    
    /**
     * Gets the course id.
     *
     * @return the course id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    public Long getCourseId() {
        return courseId;
    }

    /**
     * Sets the course id.
     *
     * @param courseId the new course id
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * Gets the term courses.
     *
     * @return the term courses
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.course", cascade=CascadeType.ALL)
    public Set<TermCourses> getTermCourses() {
        return termCourses;
    }
     
    /**
     * Sets the term courses.
     *
     * @param termCourses the new term courses
     */
    public void setTermCourses(Set<TermCourses> termCourses) {
        this.termCourses = termCourses;
    }

    /**
     * Gets the course name.
     *
     * @return the course name
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name.
     *
     * @param courseName the new course name
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) &&
                Objects.equals(courseName, course.courseName);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName);
    }
}
