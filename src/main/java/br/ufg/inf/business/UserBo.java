package br.ufg.inf.business;

import br.ufg.inf.business.contracts.IUserBo;
import br.ufg.inf.dao.contracts.UserDaoContract;
import br.ufg.inf.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserBo implements IUserBo {

    @Autowired
    UserDaoContract userDao;

    @Override
    public Long getLoggedUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userDao.getByLogin(auth.getName()).getUser().getPersonId();

    }

    @Override
    public String getLoggedUserName() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userDao.getByLogin(auth.getName()).getUser().getName();

    }

    @Override
    public List<User> listAll() {
        return null;
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public void edit(User user) {

    }
}
