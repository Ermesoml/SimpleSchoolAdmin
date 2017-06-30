package br.ufg.inf.bean;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;


/**
 * BarsBean
 * 
 * Bean responsável por gerenciar sessão e barra do topo
 */
@ManagedBean(name = "barsBean")
public class BarsBean extends MB {

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Gets the logged username.
	 *
	 * @return the logged username
	 */
	public String getLoggedUsername(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    /**
     * Gets the logged user.
     *
     * @return the logged user
     */
    public String getLoggedUser() {
        return getUserService().getLoggedUserName();
    }

}
