package com.csufg2016.dao;

import com.csufg2016.dao.contracts.AssignmentDaoContract;
import com.csufg2016.entities.Assignment;
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
        criteria.add(Restrictions.eq("term.termId", termId));
        criteria.add(Restrictions.eq("course.courseId", courseId));

        return (List<Assignment>) criteria.list();


    }
}
