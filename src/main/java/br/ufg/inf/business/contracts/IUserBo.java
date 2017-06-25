package br.ufg.inf.business.contracts;

import br.ufg.inf.entities.User;

public interface IUserBo extends BusinessContract<User> {

    Long getLoggedUser();

    String getLoggedUserName();

}
