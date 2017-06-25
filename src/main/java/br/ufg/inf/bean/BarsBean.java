package br.ufg.inf.bean;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "barsBean")
public class BarsBean extends MB {

    public String getLoggedUsername(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    public String getLoggedUser() {
        return getUserService().getLoggedUserName();
    }

}
