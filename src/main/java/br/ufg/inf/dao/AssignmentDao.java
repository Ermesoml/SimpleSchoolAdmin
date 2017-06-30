package br.ufg.inf.dao;

import br.ufg.inf.dao.contracts.AssignmentDaoContract;
import br.ufg.inf.entities.Assignment;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Class AssignmentDao.
 */
@Repository
public class AssignmentDao extends GenericDao<Assignment> implements AssignmentDaoContract {

    /**
     * Instantiates a new assignment dao.
     */
    public AssignmentDao(){
        super(Assignment.class);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.AssignmentDaoContract#obtainByTermAndCourse(java.lang.Long, java.lang.Long)
     */
    @SuppressWarnings("unchecked")
	@Override
    public List<Assignment> obtainByTermAndCourse(Long termId, Long courseId) {

        Criteria criteria = dbSession().createCriteria(Assignment.class);
        criteria.createAlias("term", "term");

        criteria.add(Restrictions.eq("term.pk.term.termId", termId));

        if (courseId != null)
            criteria.add(Restrictions.eq("term.pk.course.courseId", courseId));

        return (List<Assignment>) criteria.list();


    }
}
