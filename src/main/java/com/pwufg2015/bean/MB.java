package com.pwufg2015.bean;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class MB {

    protected Flash flashContainer(){
        return getFacesContext().getExternalContext().getFlash();
    }

    protected Map<String, Object> requestContainer(){
        return getFacesContext().getExternalContext().getRequestMap();
    }

    protected HttpServletRequest getRequest() {
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();
    }

    protected FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
