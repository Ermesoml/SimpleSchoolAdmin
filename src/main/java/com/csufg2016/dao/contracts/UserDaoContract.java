package com.csufg2016.dao.contracts;

import com.csufg2016.entities.User;

public interface UserDaoContract extends GenericDaoContract<User> {

    User getByLogin(String login);


    @Override
    void add(User user);

    @Override
    void update(User user);

    @Override
    User get(long id);

    @Override
    void delete(User user);
}
