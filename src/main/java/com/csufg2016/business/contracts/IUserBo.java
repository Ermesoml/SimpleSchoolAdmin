package com.csufg2016.business.contracts;

import com.csufg2016.entities.User;

public interface IUserBo extends BusinessContract<User> {

    Long getLoggedUser();

    String getLoggedUserName();

}
