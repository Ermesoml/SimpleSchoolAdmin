package com.pwufg2015.dao;

import com.pwufg2015.dao.contracts.TermDaoContract;
import com.pwufg2015.entities.Term;
import org.springframework.stereotype.Repository;

@Repository
public class TermDao extends GenericDao<Term> implements TermDaoContract {

    protected TermDao() {
        super(Term.class);
    }

}
