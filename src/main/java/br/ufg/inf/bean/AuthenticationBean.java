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

@RequestScoped
@ManagedBean(name = "authBean")
public class AuthenticationBean extends MB {

    private String userName = null;
    private String password = null;

    @ManagedProperty(value="#{authenticationManager}")
    private AuthenticationManager authenticationManager;

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

    public String cancel() {
        return null;
    }

    public String logout(){
        SecurityContextHolder.clearContext();
        return "/login.xhtml";
    }

    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
