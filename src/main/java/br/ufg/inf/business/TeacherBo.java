package br.ufg.inf.business;

import br.ufg.inf.entities.Teacher;
import br.ufg.inf.business.contracts.ITeacherBo;
import br.ufg.inf.dao.contracts.CourseDaoContract;
import br.ufg.inf.dao.contracts.TeacherDaoContract;
import br.ufg.inf.entities.TermCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The Class TeacherBo.
 */
@Service("TeacherService")
@Transactional(readOnly = true)
public class TeacherBo implements ITeacherBo {

    /** The teacher dao. */
    @Autowired
    TeacherDaoContract teacherDao;

    /** The course dao. */
    @Autowired
    CourseDaoContract courseDao;

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.ITeacherBo#newTeacher(br.ufg.inf.entities.Teacher)
     */
    @Override
    @Transactional(readOnly = false)
    public void newTeacher(Teacher teacher) {
        teacherDao.add(teacher);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.ITeacherBo#retrieveTeacherById(long)
     */
    @Override
    public Teacher retrieveTeacherById(long id) {
        return teacherDao.get(id);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.ITeacherBo#updateTeacher(br.ufg.inf.entities.Teacher)
     */
    @Override
    @Transactional(readOnly = false)
    public void updateTeacher(Teacher teacher) {
        teacherDao.update(teacher);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.ITeacherBo#deleteTeacher(br.ufg.inf.entities.Teacher)
     */
    @Override
    @Transactional(readOnly = false)
    public void deleteTeacher(Teacher teacher) {
        teacherDao.delete(teacher);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.ITeacherBo#retrieveTeacherCourses(java.lang.Long)
     */
    @Override
    public List<TermCourses> retrieveTeacherCourses(Long teacherId) {
        return courseDao.getTermCoursesByTeacher(teacherId);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#listAll()
     */
    @Override
    public List<Teacher> listAll() {
        return teacherDao.listAll();
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#delete(java.lang.Object)
     */
    @Override
    public void delete(Teacher teacher) {
        teacherDao.delete(teacher);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#edit(java.lang.Object)
     */
    @Override
    public void edit(Teacher teacher) {
        teacherDao.update(teacher);
    }
}
