package com.csufg2016.converter;

import com.csufg2016.business.contracts.ICourseBo;
import com.csufg2016.entities.Course;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
@RequestScoped
public class courseConverter implements Converter {

    @ManagedProperty(name = "courseService", value = "#{CourseService}")
    private ICourseBo courseService;


    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if (value != null && !value.equals("")) {
            return courseService.retrieveCourseById(Long.valueOf(value));
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Course) {
            Course course = (Course) o;
            return String.valueOf(course.getCourseId());
        }
        return "";
    }

    public ICourseBo getCourseService() {
        return courseService;
    }

    public void setCourseService(ICourseBo courseService) {
        this.courseService = courseService;
    }
}
