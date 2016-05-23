package com.pwufg2015.dao;


import com.pwufg2015.dao.contracts.StudentDaoContract;
import com.pwufg2015.entities.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao extends GenericDao<Student> implements StudentDaoContract {

    protected StudentDao() {
        super(Student.class);
    }

    @Override
    public void delete(Student student) {
        student.setTermEnrolled(null);
        super.delete(student);
    }
}
