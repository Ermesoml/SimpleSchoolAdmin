package com.pwufg2015.business.contracts;

import com.pwufg2015.entities.User;

public interface IUserBo extends BusinessContract<User> {

    void newUser(User user);
    User getUserById(long id);
    void updateUser(User user);
    void deleteUser(User user);


}
