package com.csufg2016.dao;


import com.csufg2016.dao.contracts.StudentDaoContract;
import com.csufg2016.entities.Student;
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
