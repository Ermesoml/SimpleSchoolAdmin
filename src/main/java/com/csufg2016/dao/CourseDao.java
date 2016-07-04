package com.csufg2016.dao;

import com.csufg2016.dao.contracts.CourseDaoContract;
import com.csufg2016.entities.Course;
import com.csufg2016.entities.TermCourses;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao extends GenericDao<Course> implements CourseDaoContract {

    public CourseDao() {
        super(Course.class);
    }

    @Override
    public List<TermCourses> getTermCoursesByTeacher(Long teacherId) {

        Criteria criteria = dbSession().createCriteria(TermCourses.class);
        criteria.add(Restrictions.eq("teacher.personId", teacherId));

        return (List<TermCourses>)criteria.list();

    }

}
