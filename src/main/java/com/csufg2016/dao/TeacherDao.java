package com.csufg2016.dao;

import com.csufg2016.dao.contracts.TeacherDaoContract;
import com.csufg2016.entities.Teacher;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao extends GenericDao<Teacher> implements TeacherDaoContract {

    protected TeacherDao() {
        super(Teacher.class);
    }


}
