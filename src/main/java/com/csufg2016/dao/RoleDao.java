package com.csufg2016.dao;


import com.csufg2016.dao.contracts.RoleDaoContract;
import com.csufg2016.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends GenericDao<Role> implements RoleDaoContract {

    protected RoleDao() {
        super(Role.class);
    }

}
