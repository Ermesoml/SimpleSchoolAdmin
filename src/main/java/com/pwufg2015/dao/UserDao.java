package com.pwufg2015.dao;

import com.pwufg2015.dao.contracts.UserDaoContract;
import com.pwufg2015.entities.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDao extends GenericDao<User> implements UserDaoContract {

    protected UserDao() {
        super(User.class);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User getByLogin(String login) {

        Criteria criteria = super.dbSession().createCriteria(User.class);
        List userRows;

        criteria.add(Restrictions.eq("userName", login));

        userRows = criteria.list();

        return userRows.size() != 0 ? (User)userRows.get(0) : new User();


    }
}

