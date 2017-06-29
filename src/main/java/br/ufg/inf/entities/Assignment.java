package br.ufg.inf.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Assignments")
public class Assignment implements Serializable {

    private Long assignmentId;
    private String type;
    private Date createDate;
    private Date dueDate;
    private Set<StudentAssignment> studentAssignment = new HashSet<>(0);
    private TermCourses term;
    private String dataUrlPdf;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "pk.assignment", cascade = CascadeType.ALL)
    public Set<StudentAssignment> getStudentAssignment() {
		return studentAssignment;
	}

	public void setStudentAssignment(Set<StudentAssignment> studentAssignment) {
		this.studentAssignment = studentAssignment;
	}
   
    @ManyToOne
    public TermCourses getTerm() {
		return term;
	}

	public void setTerm(TermCourses term) {
		this.term = term;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASSIGNMENT_ID")
    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getDataUrlPdf() {
        return dataUrlPdf;
    }

    public void setDataUrlPdf(String dataUrlPdf) {
        this.dataUrlPdf = dataUrlPdf;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(assignmentId, type, createDate, dueDate);
    }
}
