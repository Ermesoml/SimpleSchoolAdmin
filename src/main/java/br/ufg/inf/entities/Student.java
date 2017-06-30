package br.ufg.inf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Class Student.
 */
@Entity
@Table(name = "Students")
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class Student extends Person implements Serializable {

	/** The status. */
	private String status;
	
	/** The admittance date. */
	private Date admittanceDate;
	
	/** The ending date. */
	private Date endingDate;
	
	/** The term enrolled. */
	private Term termEnrolled;
	
	/** The student assignment. */
	private Set<StudentAssignment> studentAssignment = new HashSet<>(0);

	/**
	 * Gets the student assignment.
	 *
	 * @return the student assignment
	 */
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.student", cascade = CascadeType.ALL)
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
	 * Gets the term enrolled.
	 *
	 * @return the term enrolled
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	public Term getTermEnrolled() {
		return termEnrolled;
	}

	/**
	 * Sets the term enrolled.
	 *
	 * @param termEnrolled the new term enrolled
	 */
	public void setTermEnrolled(Term termEnrolled) {
		this.termEnrolled = termEnrolled;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the admittance date.
	 *
	 * @return the admittance date
	 */
	public Date getAdmittanceDate() {
		return admittanceDate;
	}

	/**
	 * Sets the admittance date.
	 *
	 * @param admittanceDate the new admittance date
	 */
	public void setAdmittanceDate(Date admittanceDate) {
		this.admittanceDate = admittanceDate;
	}

	/**
	 * Gets the ending date.
	 *
	 * @return the ending date
	 */
	public Date getEndingDate() {
		return endingDate;
	}

	/**
	 * Sets the ending date.
	 *
	 * @param endingDate the new ending date
	 */
	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(status, student.status) &&
				Objects.equals(admittanceDate, student.admittanceDate) &&
				Objects.equals(endingDate, student.endingDate);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(status, admittanceDate, endingDate);
	}
}
