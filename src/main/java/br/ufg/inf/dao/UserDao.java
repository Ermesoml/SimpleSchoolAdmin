package br.ufg.inf.dao;

import br.ufg.inf.dao.contracts.UserDaoContract;
import br.ufg.inf.entities.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Class UserDao.
 */
@Repository
@Transactional
public class UserDao extends GenericDao<User> implements UserDaoContract {

    /**
     * Instantiates a new user dao.
     */
    protected UserDao() {
        super(User.class);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.UserDaoContract#getByLogin(java.lang.String)
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User getByLogin(String login) {

        Criteria criteria = super.dbSession().createCriteria(User.class);
        List<?> userRows;

        criteria.add(Restrictions.eq("userName", login));

        userRows = criteria.list();

        return userRows.size() != 0 ? (User)userRows.get(0) : new User();


    }
}

