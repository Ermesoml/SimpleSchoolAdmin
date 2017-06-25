package br.ufg.inf.dao;


import br.ufg.inf.dao.contracts.StudentDaoContract;
import br.ufg.inf.entities.Student;
import br.ufg.inf.entities.TermCourses;
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
