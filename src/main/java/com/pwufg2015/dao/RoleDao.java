package com.pwufg2015.dao;


import com.pwufg2015.dao.contracts.RoleDaoContract;
import com.pwufg2015.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends GenericDao<Role> implements RoleDaoContract {

    protected RoleDao() {
        super(Role.class);
    }

}
