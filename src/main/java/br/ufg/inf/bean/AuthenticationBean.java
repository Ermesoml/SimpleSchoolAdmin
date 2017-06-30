package br.ufg.inf.bean;

import org.primefaces.context.RequestContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 * AuthenticationBean
 * 
 * Controlador Responsável por direcionar as chamadas de autenticação
 * 
 * 
 * @author ygors
 */
@RequestScoped
@ManagedBean(name = "authBean")
public class AuthenticationBean extends MB {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The user name. */
    private String userName = null;
    
    /** The password. */
    private String password = null;

    /** The authentication manager. */
    @ManagedProperty(value="#{authenticationManager}")
    private AuthenticationManager authenticationManager;

    /**
     * Realiza o Login do Usuário
     *
     * @return the string
     */
    public String login() {

        RequestContext context = RequestContext.getCurrentInstance();

        try {
            Authentication request = new UsernamePasswordAuthenticationToken(getUserName(), getPassword());
            Authentication result = authenticationManager.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
        } catch (AuthenticationException e) {

            context.addCallbackParam("isValid", false);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de Autenticação: ", "Usuário Inválido"));

            return "loginFailure";
        }

        context.addCallbackParam("isValid", true);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Autenticado: ", "Logando..."));

        return "loginSuccess";

    }

    /**
     * Redirect if logged.
     */
    public void redirectIfLogged(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            try {
                getFacesContext().getExternalContext().redirect(
                        getRequest().getContextPath() + "/dashboard.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Cancel.
     *
     * @return the string
     */
    public String cancel() {
        return null;
    }

    /**
     * Logout.
     *
     * @return the string
     */
    public String logout(){
        SecurityContextHolder.clearContext();
        return "/login.xhtml";
    }

    /**
     * Gets the authentication manager.
     *
     * @return the authentication manager
     */
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    /**
     * Sets the authentication manager.
     *
     * @param authenticationManager the new authentication manager
     */
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName the new user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }



}
