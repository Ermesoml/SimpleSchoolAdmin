package com.pwufg2015.converter;

import com.pwufg2015.business.contracts.ITeacherBo;
import com.pwufg2015.entities.Teacher;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
@RequestScoped
public class teacherConverter implements Converter {

    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if (s != null && !s.equals("")) {
            return teacherService.retrieveTeacherById(Long.valueOf(s));
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        if (o instanceof Teacher) {
            Teacher teacher = (Teacher) o;
            return String.valueOf(teacher.getPersonId());
        }

        return "";
    }

    public ITeacherBo getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(ITeacherBo teacherService) {
        this.teacherService = teacherService;
    }

}
