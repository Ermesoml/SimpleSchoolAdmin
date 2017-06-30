package br.ufg.inf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The Class StudentAssignment.
 */
@Entity
@Table(name = "StudentAssignment")
@AssociationOverrides({ @AssociationOverride(name = "pk.student", joinColumns = @JoinColumn(name = "PERSON_ID") ),
		@AssociationOverride(name = "pk.assignment", joinColumns = @JoinColumn(name = "ASSIGNMENT_ID") ) })
public class StudentAssignment implements Serializable {

	/**
	 * The Class StudentAssignmentId.
	 */
	@Embeddable
	public class StudentAssignmentId implements Serializable {

		/** The student. */
		private Student student;
		
		/** The assignment. */
		private Assignment assignment;

		/**
		 * Gets the student.
		 *
		 * @return the student
		 */
		@ManyToOne
		public Student getStudent() {
			return student;
		}

		/**
		 * Sets the student.
		 *
		 * @param student the new student
		 */
		public void setStudent(Student student) {
			this.student = student;
		}

		/**
		 * Gets the assignment.
		 *
		 * @return the assignment
		 */
		@ManyToOne
		public Assignment getAssignment() {
			return assignment;
		}

		/**
		 * Sets the assignment.
		 *
		 * @param assignment the new assignment
		 */
		public void setAssignment(Assignment assignment) {
			this.assignment = assignment;
		}

	}
	
	/** The pk. */
	private StudentAssignmentId pk = new StudentAssignmentId();
	
	/** The grade. */
	private BigDecimal grade;
	
	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public BigDecimal getGrade() {
		return grade;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade the new grade
	 */
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	/**
	 * Gets the pk.
	 *
	 * @return the pk
	 */
	@EmbeddedId
	public StudentAssignmentId getPk() {
        return pk;
    }

    /**
     * Sets the pk.
     *
     * @param pk the new pk
     */
    public void setPk(StudentAssignmentId pk) {
        this.pk = pk;
    }

    /**
     * Gets the student.
     *
     * @return the student
     */
    @Transient
    public Student getStudent(){
        return getPk().getStudent();
    }

    /**
     * Sets the student.
     *
     * @param student the new student
     */
    public void setStudent(Student student){
        getPk().setStudent(student);
    }

    /**
     * Gets the assignment.
     *
     * @return the assignment
     */
    @Transient
    public Assignment getAssignment(){
        return getPk().getAssignment();
    }

    /**
     * Sets the assignment.
     *
     * @param assignment the new assignment
     */
    public void setAssignment(Assignment assignment){
        getPk().setAssignment(assignment);
    }
}
