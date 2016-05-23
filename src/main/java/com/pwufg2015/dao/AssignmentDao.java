package com.pwufg2015.dao;

import com.pwufg2015.dao.contracts.AssignmentDaoContract;
import com.pwufg2015.entities.Assignment;
import org.springframework.stereotype.Repository;

@Repository
public class AssignmentDao extends GenericDao<Assignment> implements AssignmentDaoContract {

    public AssignmentDao(){
        super(Assignment.class);
    }

}
