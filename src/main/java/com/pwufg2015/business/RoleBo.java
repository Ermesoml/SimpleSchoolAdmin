package com.pwufg2015.business;


import com.pwufg2015.business.contracts.IRoleBo;
import com.pwufg2015.dao.contracts.RoleDaoContract;
import com.pwufg2015.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleBo implements IRoleBo {

    @Autowired
    private RoleDaoContract role;

    @Override
    public Role getRole(int id) {
        return role.get(id);
    }

}
