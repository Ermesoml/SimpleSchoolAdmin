package br.ufg.inf.converter;

import br.ufg.inf.business.contracts.ICourseBo;
import br.ufg.inf.entities.Course;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * The Class courseConverter.
 * 
 * Responsável por converter objetos de controlador para objetos de contexto
 */
@ManagedBean
@RequestScoped
public class courseConverter implements Converter {

    /** The course service. */
    @ManagedProperty(name = "courseService", value = "#{CourseService}")
    private ICourseBo courseService;


    /* (non-Javadoc)
     * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
     */
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value != null && !value.equals("")) {
            return courseService.retrieveCourseById(Long.valueOf(value));
        }

        return null;
    }

    /* (non-Javadoc)
     * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
     */
    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Course) {
            Course course = (Course) o;
            return String.valueOf(course.getCourseId());
        }
        return "";
    }

    /**
     * Gets the course service.
     *
     * @return the course service
     */
    public ICourseBo getCourseService() {
        return courseService;
    }

    /**
     * Sets the course service.
     *
     * @param courseService the new course service
     */
    public void setCourseService(ICourseBo courseService) {
        this.courseService = courseService;
    }
}
