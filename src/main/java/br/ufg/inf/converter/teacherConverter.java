package br.ufg.inf.converter;

import br.ufg.inf.entities.Teacher;
import br.ufg.inf.business.contracts.ITeacherBo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
* Responsável por converter objetos de controlador para objetos de contexto
 */
@ManagedBean
@RequestScoped
public class teacherConverter implements Converter {

    /** The teacher service. */
    @ManagedProperty(name = "teacherService", value = "#{TeacherService}")
    private ITeacherBo teacherService;


    /* (non-Javadoc)
     * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
     */
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {

        if (s != null && !s.equals("")) {
            return teacherService.retrieveTeacherById(Long.valueOf(s));
        }

        return null;
    }

    /* (non-Javadoc)
     * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {

        if (o instanceof Teacher) {
            Teacher teacher = (Teacher) o;
            return String.valueOf(teacher.getPersonId());
        }

        return "";
    }

    /**
     * Gets the teacher service.
     *
     * @return the teacher service
     */
    public ITeacherBo getTeacherService() {
        return teacherService;
    }

    /**
     * Sets the teacher service.
     *
     * @param teacherService the new teacher service
     */
    public void setTeacherService(ITeacherBo teacherService) {
        this.teacherService = teacherService;
    }

}
