package br.ufg.inf.dao;

import br.ufg.inf.dao.contracts.TermDaoContract;
import br.ufg.inf.entities.Term;
import org.springframework.stereotype.Repository;


/**
 * The Class TermDao.
 */
@Repository
public class TermDao extends GenericDao<Term> implements TermDaoContract {

    /**
     * Instantiates a new term dao.
     */
    protected TermDao() {
        super(Term.class);
    }

}
