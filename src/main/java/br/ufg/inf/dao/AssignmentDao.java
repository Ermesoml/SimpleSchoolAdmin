package br.ufg.inf.dao;

import br.ufg.inf.dao.contracts.AssignmentDaoContract;
import br.ufg.inf.entities.Assignment;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssignmentDao extends GenericDao<Assignment> implements AssignmentDaoContract {

    public AssignmentDao(){
        super(Assignment.class);
    }

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
