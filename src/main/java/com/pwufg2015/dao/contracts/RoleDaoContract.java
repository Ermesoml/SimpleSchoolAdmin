package com.pwufg2015.dao.contracts;


import com.pwufg2015.entities.Role;
import com.pwufg2015.entities.Student;

public interface RoleDaoContract  extends GenericDaoContract<Role>{

   @Override
   Role get(long id);

}
