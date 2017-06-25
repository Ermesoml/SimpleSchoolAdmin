package br.ufg.inf.dao.contracts;


import br.ufg.inf.entities.Role;

public interface RoleDaoContract  extends GenericDaoContract<Role>{

   @Override
   Role get(long id);

}
