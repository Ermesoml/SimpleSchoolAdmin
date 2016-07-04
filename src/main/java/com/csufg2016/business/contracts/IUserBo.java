package com.csufg2016.business.contracts;

import com.csufg2016.entities.User;

public interface IUserBo extends BusinessContract<User> {

    void newUser(User user);
    User getUserById(long id);
    void updateUser(User user);
    void deleteUser(User user);
    User getLoggedUser();

}
