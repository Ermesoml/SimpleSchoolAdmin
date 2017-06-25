package br.ufg.inf.dao;

import br.ufg.inf.entities.Teacher;
import br.ufg.inf.dao.contracts.TeacherDaoContract;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDao extends GenericDao<Teacher> implements TeacherDaoContract {

    protected TeacherDao() {
        super(Teacher.class);
    }


}
