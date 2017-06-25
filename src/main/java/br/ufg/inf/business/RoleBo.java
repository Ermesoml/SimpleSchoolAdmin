package br.ufg.inf.business;


import br.ufg.inf.business.contracts.IRoleBo;
import br.ufg.inf.dao.contracts.RoleDaoContract;
import br.ufg.inf.entities.Role;
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
