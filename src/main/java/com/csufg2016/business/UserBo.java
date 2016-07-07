package com.csufg2016.business;

import com.csufg2016.business.contracts.IUserBo;
import com.csufg2016.dao.contracts.UserDaoContract;
import com.csufg2016.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserBo implements IUserBo {

    @Autowired
    UserDaoContract userDao;

    public Long getLoggedUser() {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userDao.getByLogin(auth.getName()).getUser().getPersonId();

    }

    @Override
    public void newUser(User user) {

    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

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
