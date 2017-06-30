package br.ufg.inf.dao;

import br.ufg.inf.dao.contracts.CourseDaoContract;
import br.ufg.inf.entities.Course;
import br.ufg.inf.entities.TermCourses;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Class CourseDao.
 */
@Repository
public class CourseDao extends GenericDao<Course> implements CourseDaoContract {

    /**
     * Instantiates a new course dao.
     */
    public CourseDao() {
        super(Course.class);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.CourseDaoContract#getTermCoursesByTeacher(java.lang.Long)
     */
    @SuppressWarnings("unchecked")
	@Override
    public List<TermCourses> getTermCoursesByTeacher(Long teacherId) {

        Criteria criteria = dbSession().createCriteria(TermCourses.class);
        criteria.add(Restrictions.eq("teacher.personId", teacherId));

        return (List<TermCourses>)criteria.list();

    }

}
