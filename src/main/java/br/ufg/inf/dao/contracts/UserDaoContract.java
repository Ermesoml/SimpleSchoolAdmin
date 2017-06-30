package br.ufg.inf.dao.contracts;

import br.ufg.inf.entities.User;

/**
 * The Interface UserDaoContract.
 */
public interface UserDaoContract extends GenericDaoContract<User> {

    /**
     * Gets the by login.
     *
     * @param login the login
     * @return the by login
     */
    User getByLogin(String login);

    /**
     * @see br.ufg.inf.dao.contracts.GenericDaoContract#add(java.lang.Object)
     */
    @Override
    void add(User user);

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.GenericDaoContract#update(java.lang.Object)
     */
    @Override
    void update(User user);

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.GenericDaoContract#get(long)
     */
    @Override
    User get(long id);

    /* (non-Javadoc)
     * @see br.ufg.inf.dao.contracts.GenericDaoContract#delete(java.lang.Object)
     */
    @Override
    void delete(User user);
}
