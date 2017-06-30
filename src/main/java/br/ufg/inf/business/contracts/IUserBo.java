package br.ufg.inf.business.contracts;

import br.ufg.inf.entities.User;

/**
 * The Interface IUserBo.
 */
public interface IUserBo extends BusinessContract<User> {

    /**
     * Gets the logged user.
     *
     * @return the logged user
     */
    Long getLoggedUser();

    /**
     * Gets the logged user name.
     *
     * @return the logged user name
     */
    String getLoggedUserName();

}
