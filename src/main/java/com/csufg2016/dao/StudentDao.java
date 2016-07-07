package com.csufg2016.dao;


import com.csufg2016.dao.contracts.StudentDaoContract;
import com.csufg2016.entities.Student;
import com.csufg2016.entities.TermCourses;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<TermCourses> getEnrolledCourses(Long termId) {

        Criteria criteria = dbSession().createCriteria(TermCourses.class);
        criteria.add(Restrictions.eq("pk.term.termId", termId));
        return (List<TermCourses>) criteria.list();


    }
}
