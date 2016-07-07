package com.csufg2016.business;

import com.csufg2016.business.contracts.ITeacherBo;
import com.csufg2016.dao.contracts.CourseDaoContract;
import com.csufg2016.dao.contracts.TeacherDaoContract;
import com.csufg2016.entities.Teacher;
import com.csufg2016.entities.TermCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("TeacherService")
@Transactional(readOnly = true)
public class TeacherBo implements ITeacherBo {

    @Autowired
    TeacherDaoContract teacherDao;

    @Autowired
    CourseDaoContract courseDao;

    @Override
    @Transactional(readOnly = false)
    public void newTeacher(Teacher teacher) {
        teacherDao.add(teacher);
    }

    @Override
    public Teacher retrieveTeacherById(long id) {
        return teacherDao.get(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateTeacher(Teacher teacher) {
        teacherDao.update(teacher);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteTeacher(Teacher teacher) {
        teacherDao.delete(teacher);
    }

    @Override
    public List<TermCourses> retrieveTeacherCourses(Long teacherId) {
        return courseDao.getTermCoursesByTeacher(teacherId);
    }

    @Override
    public List<Teacher> listAll() {
        return teacherDao.listAll();
    }

    @Override
    public void delete(Teacher teacher) {
        teacherDao.delete(teacher);
    }

    @Override
    public void edit(Teacher teacher) {
        teacherDao.update(teacher);
    }
}
