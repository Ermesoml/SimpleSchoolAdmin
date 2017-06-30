package br.ufg.inf.dao;


import br.ufg.inf.dao.contracts.RoleDaoContract;
import br.ufg.inf.entities.Role;
import org.springframework.stereotype.Repository;

/**
 * The Class RoleDao.
 */
@Repository
public class RoleDao extends GenericDao<Role> implements RoleDaoContract {

    /**
     * Instantiates a new role dao.
     */
    protected RoleDao() {
        super(Role.class);
    }

}
