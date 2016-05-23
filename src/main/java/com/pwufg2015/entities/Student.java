package com.pwufg2015.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Students")
@PrimaryKeyJoinColumn(name = "PERSON_ID")
public class Student extends Person implements Serializable {

	private String status;
	private Date admittanceDate;
	private Date endingDate;
	private Term termEnrolled;
	private Set<StudentAssignment> studentAssignment = new HashSet<>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.student", cascade = CascadeType.ALL)
	public Set<StudentAssignment> getStudentAssignment() {
		return studentAssignment;
	}

	public void setStudentAssignment(Set<StudentAssignment> studentAssignment) {
		this.studentAssignment = studentAssignment;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	public Term getTermEnrolled() {
		return termEnrolled;
	}

	public void setTermEnrolled(Term termEnrolled) {
		this.termEnrolled = termEnrolled;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAdmittanceDate() {
		return admittanceDate;
	}

	public void setAdmittanceDate(Date admittanceDate) {
		this.admittanceDate = admittanceDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Student student = (Student) o;
		return Objects.equals(status, student.status) &&
				Objects.equals(admittanceDate, student.admittanceDate) &&
				Objects.equals(endingDate, student.endingDate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(status, admittanceDate, endingDate);
	}
}
