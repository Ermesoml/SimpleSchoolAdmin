package br.ufg.inf.dao;


import br.ufg.inf.dao.contracts.StudentDaoContract;
import br.ufg.inf.entities.Student;
import br.ufg.inf.entities.TermCourses;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Class StudentDao.
 */
@Repository
public class StudentDao extends GenericDao<Student> implements StudentDaoContract {

    /**
     * Instantiates a new student dao.
     */
    protected StudentDao() {
        super(Student.class);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.GenericDao#delete(java.io.Serializable)
     */
    @Override
    public void delete(Student student) {
        student.setTermEnrolled(null);
        super.delete(student);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.StudentDaoContract#getEnrolledCourses(java.lang.Long)
     */
    @SuppressWarnings("unchecked")
	@Override
    public List<TermCourses> getEnrolledCourses(Long termId) {

        Criteria criteria = dbSession().createCriteria(TermCourses.class);
        criteria.add(Restrictions.eq("pk.term.termId", termId));
        return (List<TermCourses>) criteria.list();


    }
}
