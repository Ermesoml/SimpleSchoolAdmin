package br.ufg.inf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Class Assignment.
 */
@Entity
@Table(name = "Assignments")
public class Assignment implements Serializable {

    /** The assignment id. */
    private Long assignmentId;
    
    /** The type. */
    private String type;
    
    /** The create date. */
    private Date createDate;
    
    /** The due date. */
    private Date dueDate;
    
    /** The student assignment. */
    private Set<StudentAssignment> studentAssignment = new HashSet<>(0);
    
    /** The term. */
    private TermCourses term;
    
    /** The data url pdf. */
    private String dataUrlPdf;

    /**
     * Gets the student assignment.
     *
     * @return the student assignment
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.assignment", cascade = CascadeType.ALL)
    public Set<StudentAssignment> getStudentAssignment() {
		return studentAssignment;
	}

	/**
	 * Sets the student assignment.
	 *
	 * @param studentAssignment the new student assignment
	 */
	public void setStudentAssignment(Set<StudentAssignment> studentAssignment) {
		this.studentAssignment = studentAssignment;
	}
   
    /**
     * Gets the term.
     *
     * @return the term
     */
    @ManyToOne
    public TermCourses getTerm() {
		return term;
	}

	/**
	 * Sets the term.
	 *
	 * @param term the new term
	 */
	public void setTerm(TermCourses term) {
		this.term = term;
	}

	/**
	 * Gets the assignment id.
	 *
	 * @return the assignment id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASSIGNMENT_ID")
    public Long getAssignmentId() {
        return assignmentId;
    }

    /**
     * Sets the assignment id.
     *
     * @param assignmentId the new assignment id
     */
    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    /**
     * Gets the type.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type.
     *
     * @param type the new type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the creates the date.
     *
     * @return the creates the date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * Sets the creates the date.
     *
     * @param createDate the new creates the date
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets the due date.
     *
     * @return the due date
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date.
     *
     * @param dueDate the new due date
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the data url pdf.
     *
     * @return the data url pdf
     */
    public String getDataUrlPdf() {
        return dataUrlPdf;
    }

    /**
     * Sets the data url pdf.
     *
     * @param dataUrlPdf the new data url pdf
     */
    public void setDataUrlPdf(String dataUrlPdf) {
        this.dataUrlPdf = dataUrlPdf;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assignment that = (Assignment) o;
        return Objects.equals(assignmentId, that.assignmentId) &&
                Objects.equals(type, that.type) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(dueDate, that.dueDate);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(assignmentId, type, createDate, dueDate);
    }
}
