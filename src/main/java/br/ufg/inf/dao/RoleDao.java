package br.ufg.inf.dao;


import br.ufg.inf.dao.contracts.RoleDaoContract;
import br.ufg.inf.entities.Role;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends GenericDao<Role> implements RoleDaoContract {

    protected RoleDao() {
        super(Role.class);
    }

}
