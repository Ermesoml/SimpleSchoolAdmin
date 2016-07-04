package com.csufg2016.dao;

import com.csufg2016.dao.contracts.TermDaoContract;
import com.csufg2016.entities.Term;
import org.springframework.stereotype.Repository;


@Repository
@SuppressWarnings("unchecked")
public class TermDao extends GenericDao<Term> implements TermDaoContract {

    protected TermDao() {
        super(Term.class);
    }

}
