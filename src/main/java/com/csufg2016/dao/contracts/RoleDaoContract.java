package com.csufg2016.dao.contracts;


import com.csufg2016.entities.Role;

public interface RoleDaoContract  extends GenericDaoContract<Role>{

   @Override
   Role get(long id);

}
