package br.ufg.inf.business;

import br.ufg.inf.business.contracts.IUserBo;
import br.ufg.inf.dao.contracts.UserDaoContract;
import br.ufg.inf.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Class UserBo.
 */
@Service("UserService")
public class UserBo implements IUserBo {

    /** The user dao. */
    @Autowired
    UserDaoContract userDao;

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IUserBo#getLoggedUser()
     */
    @Override
    public Long getLoggedUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userDao.getByLogin(auth.getName()).getUser().getPersonId();

    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IUserBo#getLoggedUserName()
     */
    @Override
    public String getLoggedUserName() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userDao.getByLogin(auth.getName()).getUser().getName();

    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#listAll()
     */
    @Override
    public List<User> listAll() {
        return null;
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#delete(java.lang.Object)
     */
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#edit(java.lang.Object)
     */
    @Override
    public void edit(User user) {

    }
}
