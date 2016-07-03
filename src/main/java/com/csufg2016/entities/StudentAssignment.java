package com.csufg2016.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "StudentAssignment")
@AssociationOverrides({ @AssociationOverride(name = "pk.student", joinColumns = @JoinColumn(name = "PERSON_ID") ),
		@AssociationOverride(name = "pk.assignment", joinColumns = @JoinColumn(name = "ASSIGNMENT_ID") ) })
public class StudentAssignment implements Serializable {

	@Embeddable
	public class StudentAssignmentId implements Serializable {

		private Student student;
		private Assignment assignment;

		@ManyToOne
		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		@ManyToOne
		public Assignment getAssignment() {
			return assignment;
		}

		public void setAssignment(Assignment assignment) {
			this.assignment = assignment;
		}

	}
	private StudentAssignmentId pk = new StudentAssignmentId();
	
	private BigDecimal grade;
	
	public BigDecimal getGrade() {
		return grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	@EmbeddedId
	public StudentAssignmentId getPk() {
        return pk;
    }

    public void setPk(StudentAssignmentId pk) {
        this.pk = pk;
    }

    @Transient
    public Student getStudent(){
        return getPk().getStudent();
    }

    public void setStudent(Student student){
        getPk().setStudent(student);
    }

    @Transient
    public Assignment getAssignment(){
        return getPk().getAssignment();
    }

    public void setAssignment(Assignment assignment){
        getPk().setAssignment(assignment);
    }
}
