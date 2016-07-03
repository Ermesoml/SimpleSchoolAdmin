package com.csufg2016.dao;

import com.csufg2016.dao.contracts.CourseDaoContract;
import com.csufg2016.entities.Course;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao extends GenericDao<Course> implements CourseDaoContract {

    public CourseDao() {
        super(Course.class);
    }

}
