package br.ufg.inf.business;

import br.ufg.inf.business.contracts.IAuthBo;
import br.ufg.inf.dao.contracts.UserDaoContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * The Class AuthBo.
 */
@Service("AuthService")
public class AuthBo implements IAuthBo, UserDetailsService {

    /** The user dao. */
    @Autowired
    UserDaoContract userDao;

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        br.ufg.inf.entities.User domainUser = userDao.getByLogin(login);

        if (domainUser.getUserName().equals(""))
            throw new UsernameNotFoundException("Usuário não encontrado");

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return new User(
                domainUser.getUserName(),
                domainUser.getPassword(),
                enabled,
                accountNonExpired,
                credentialsNonExpired,
                accountNonLocked,
                getAuthorities(domainUser.getRole().getId())
        );
    }

    /**
     * Gets the authorities.
     *
     * @param role the role
     * @return the authorities
     */
    public Collection<? extends GrantedAuthority> getAuthorities(Long role) {
        return getGrantedAuthorities(getRoles(role));
    }

    /**
     * Gets the roles.
     *
     * @param role the role
     * @return the roles
     */
    public List<String> getRoles(Long role) {

        List<String> roles = new ArrayList<>();

        if (role.intValue() == 1)
            roles.add("ROLE_ADMIN");
        else if (role.intValue() == 2)
            roles.add("ROLE_STUDENT");
        else if (role.intValue() == 3)
            roles.add("ROLE_TEACHER");

        return roles;
    }

    /**
     * Gets the granted authorities.
     *
     * @param roles the roles
     * @return the granted authorities
     */
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
