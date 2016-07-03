package com.csufg2016.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Teachers")
@PrimaryKeyJoinColumn(name="PERSON_ID")
public class Teacher extends Person implements Serializable {

    private Boolean active;
    private Date admittanceDate;
    private Date endingDate;
    private String major;
    private BigDecimal salary;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(active, admittanceDate, endingDate, major, salary);
    }
}
