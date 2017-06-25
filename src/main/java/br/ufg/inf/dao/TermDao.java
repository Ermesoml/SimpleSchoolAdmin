package br.ufg.inf.dao;

import br.ufg.inf.dao.contracts.TermDaoContract;
import br.ufg.inf.entities.Term;
import org.springframework.stereotype.Repository;


@Repository
@SuppressWarnings("unchecked")
public class TermDao extends GenericDao<Term> implements TermDaoContract {

    protected TermDao() {
        super(Term.class);
    }

}
