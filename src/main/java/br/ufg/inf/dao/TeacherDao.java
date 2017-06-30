package br.ufg.inf.dao;

import br.ufg.inf.entities.Teacher;
import br.ufg.inf.dao.contracts.TeacherDaoContract;
import org.springframework.stereotype.Repository;

/**
 * The Class TeacherDao.
 */
@Repository
public class TeacherDao extends GenericDao<Teacher> implements TeacherDaoContract {

    /**
     * Instantiates a new teacher dao.
     */
    protected TeacherDao() {
        super(Teacher.class);
    }


}
