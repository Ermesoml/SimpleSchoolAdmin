package com.pwufg2015.dao;

import com.pwufg2015.dao.contracts.CourseDaoContract;
import com.pwufg2015.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao extends GenericDao<Course> implements CourseDaoContract {

    public CourseDao() {
        super(Course.class);
    }

}
