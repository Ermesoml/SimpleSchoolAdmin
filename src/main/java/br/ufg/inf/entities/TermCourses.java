package br.ufg.inf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * The Class TermCourses.
 */
@Entity
@Table(name = "TermCourses")
@AssociationOverrides({
        @AssociationOverride(name = "pk.term",
                joinColumns = @JoinColumn(name = "TERM_ID")),
        @AssociationOverride(name = "pk.course",
                joinColumns = @JoinColumn(name = "COURSE_ID")) })
public class TermCourses implements Serializable {

    /** The pk. */
    private TermCoursesId pk = new TermCoursesId();
    
    /** The teacher. */
    private Teacher teacher;

    /**
     * Gets the pk.
     *
     * @return the pk
     */
    @EmbeddedId
    public TermCoursesId getPk() {
        return pk;
    }

    /**
     * Sets the pk.
     *
     * @param pk the new pk
     */
    public void setPk(TermCoursesId pk) {
        this.pk = pk;
    }

    /**
     * Gets the course.
     *
     * @return the course
     */
    @Transient
    public Course getCourse(){
        return getPk().getCourse();
    }

    /**
     * Sets the course.
     *
     * @param course the new course
     */
    public void setCourse(Course course){
        getPk().setCourse(course);
    }

    /**
     * Gets the teacher.
     *
     * @return the teacher
     */
    @OneToOne(fetch = FetchType.EAGER)
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * Sets the teacher.
     *
     * @param t the new teacher
     */
    public void setTeacher(Teacher t) {
        this.teacher = t;
    }

    /**
     * Gets the term.
     *
     * @return the term
     */
    @Transient
    public Term getTerm(){
        return getPk().getTerm();
    }

    /**
     * Sets the term.
     *
     * @param term the new term
     */
    public void setTerm(Term term){
        getPk().setTerm(term);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TermCourses)) return false;
        TermCourses that = (TermCourses) o;
        return Objects.equals(pk, that.pk) &&
                Objects.equals(teacher, that.teacher);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(pk, teacher);
    }

    /**
     * The Class TermCoursesId.
     */
    @Embeddable
    private static class TermCoursesId implements java.io.Serializable {

        /** The term. */
        private Term term;
        
        /** The course. */
        private Course course;

        /**
         * Gets the term.
         *
         * @return the term
         */
        @ManyToOne
        public Term getTerm() {
            return term;
        }

        /**
         * Sets the term.
         *
         * @param term the new term
         */
        public void setTerm(Term term) {
            this.term = term;
        }

        /**
         * Gets the course.
         *
         * @return the course
         */
        @ManyToOne
        public Course getCourse() {
            return course;
        }

        /**
         * Sets the course.
         *
         * @param course the new course
         */
        public void setCourse(Course course) {
            this.course = course;
        }
    }
}
