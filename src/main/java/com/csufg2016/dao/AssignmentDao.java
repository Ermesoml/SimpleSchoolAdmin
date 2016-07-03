package com.csufg2016.dao;

import com.csufg2016.dao.contracts.AssignmentDaoContract;
import com.csufg2016.entities.Assignment;
import org.springframework.stereotype.Repository;

@Repository
public class AssignmentDao extends GenericDao<Assignment> implements AssignmentDaoContract {

    public AssignmentDao(){
        super(Assignment.class);
    }

}
