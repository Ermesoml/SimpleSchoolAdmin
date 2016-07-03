package com.csufg2016.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Courses")
public class Course implements Serializable {

    private Long courseId;
    private String courseName;
    private Set<TermCourses> termCourses = new HashSet<>(0);
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.course", cascade=CascadeType.ALL)
    public Set<TermCourses> getTermCourses() {
        return termCourses;
    }
     
    public void setTermCourses(Set<TermCourses> termCourses) {
        this.termCourses = termCourses;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) &&
                Objects.equals(courseName, course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName);
    }
}
