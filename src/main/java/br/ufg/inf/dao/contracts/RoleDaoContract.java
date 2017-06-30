package br.ufg.inf.dao.contracts;


import br.ufg.inf.entities.Role;

/**
 * The Interface RoleDaoContract.
 */
public interface RoleDaoContract  extends GenericDaoContract<Role>{


   /* (non-Javadoc)
    * @see br.ufg.inf.dao.contracts.GenericDaoContract#get(long)
    */
   @Override
   Role get(long id);

}
