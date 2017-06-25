package br.ufg.inf.bean;

import br.ufg.inf.business.contracts.IUserBo;

import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Map;

public class MB implements Serializable {

    @ManagedProperty(name = "userService", value = "#{UserService}")
    private IUserBo userService;

    protected Flash flashContainer(){
        return getFacesContext().getExternalContext().getFlash();
    }

    protected Map<String, Object> requestContainer(){
        return getFacesContext().getExternalContext().getRequestMap();
    }

    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
    }

    FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    protected IUserBo getUserService() {
        return userService;
    }

    public void setUserService(IUserBo userService) {
        this.userService = userService;
    }
}
