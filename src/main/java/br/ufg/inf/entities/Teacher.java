package br.ufg.inf.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

/**
 * The Class Teacher.
 */
@Entity
@Table(name = "Teachers")
@PrimaryKeyJoinColumn(name="PERSON_ID")
public class Teacher extends Person implements Serializable {

    /** The active. */
    private Boolean active;
    
    /** The admittance date. */
    private Date admittanceDate;
    
    /** The ending date. */
    private Date endingDate;
    
    /** The major. */
    private String major;
    
    /** The salary. */
    private BigDecimal salary;

    /**
     * Gets the major.
     *
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * Sets the major.
     *
     * @param major the new major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * Gets the active.
     *
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * Sets the active.
     *
     * @param active the new active
     */
    public void setActive(Boolean active) {
        this.active = active;
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

    /**
     * Gets the salary.
     *
     * @return the salary
     */
    public BigDecimal getSalary() {
        return salary;
    }

    /**
     * Sets the salary.
     *
     * @param salary the new salary
     */
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(active, teacher.active) &&
                Objects.equals(admittanceDate, teacher.admittanceDate) &&
                Objects.equals(endingDate, teacher.endingDate) &&
                Objects.equals(major, teacher.major) &&
                Objects.equals(salary, teacher.salary);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Objects.hash(active, admittanceDate, endingDate, major, salary);
    }
}
