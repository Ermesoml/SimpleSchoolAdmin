package br.ufg.inf.business;


import br.ufg.inf.business.contracts.IRoleBo;
import br.ufg.inf.dao.contracts.RoleDaoContract;
import br.ufg.inf.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * The Class RoleBo.
 */
@Service
@Transactional
public class RoleBo implements IRoleBo {

    /** The role. */
    @Autowired
    private RoleDaoContract role;

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IRoleBo#getRole(int)
     */
    @Override
    public Role getRole(int id) {
        return role.get(id);
    }

}
