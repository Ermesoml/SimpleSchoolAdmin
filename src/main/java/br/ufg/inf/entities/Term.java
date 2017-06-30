package br.ufg.inf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Class Term.
 */
@Entity
@Table(name = "Terms")
public class Term implements Serializable {

    /** The term id. */
    private Long termId;
    
    /** The term name. */
    private String termName;
    
    /** The start date. */
    private Date startDate;
    
    /** The end date. */
    private Date endDate;

    /** The term courses. */
    private Set<TermCourses> termCourses = new HashSet<>(0);
    
    /** The term students. */
    private Set<Student> termStudents = new HashSet<>(0);

    /**
     * Gets the term id.
     *
     * @return the term id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TERM_ID")
    public Long getTermId() {
        return termId;
    }

    /**
     * Gets the term courses.
     *
     * @return the term courses
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.term", cascade=CascadeType.ALL)
    public Set<TermCourses> getTermCourses() {
        return termCourses;
    }

    /**
     * Gets the term students.
     *
     * @return the term students
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "termEnrolled", cascade = CascadeType.ALL)
    public Set<Student> getTermStudents() {
        return termStudents;
    }

    /**
     * Sets the term students.
     *
     * @param termStudents the new term students
     */
    public void setTermStudents(Set<Student> termStudents) {
        this.termStudents = termStudents;
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
     * Sets the term id.
     *
     * @param termId the new term id
     */
    public void setTermId(Long termId) {
        this.termId = termId;
    }

    /**
     * Gets the term name.
     *
     * @return the term name
     */
    public String getTermName() {
        return termName;
    }

    /**
     * Sets the term name.
     *
     * @param termName the new term name
     */
    public void setTermName(String termName) {
        this.termName = termName;
    }

    /**
     * Gets the start date.
     *
     * @return the start date
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date.
     *
     * @param startDate the new start date
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date.
     *
     * @return the end date
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date.
     *
     * @param endDate the new end date
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Term)) return false;
        Term term = (Term) o;
        return Objects.equals(termId, term.termId) &&
                Objects.equals(termName, term.termName) &&
                Objects.equals(startDate, term.startDate) &&
                Objects.equals(endDate, term.endDate);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(termId, termName, startDate, endDate);
    }
}
