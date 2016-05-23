package com.pwufg2015.business;

import com.pwufg2015.Utils.Pair;
import com.pwufg2015.business.contracts.ITermBo;
import com.pwufg2015.dao.contracts.TermDaoContract;
import com.pwufg2015.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("TermService")
@Transactional(readOnly = true)
public class TermBo implements ITermBo {

    @Autowired
    TermDaoContract termDao;

    @Transactional(readOnly = false)
    public void newObject(Term term) {
        termDao.add(term);
    }

    @Override
    @Transactional(readOnly = false)
    public void newTerm(Term term, List<Pair<Course, Teacher>> courses) {

        TermCourses termCourse;
        Set<TermCourses> termCourses = new HashSet<>(0);

        for(Pair<Course,Teacher> pair : courses){

            termCourse = new TermCourses();

            termCourse.setTerm( term );
            termCourse.setCourse( pair.getX() );
            termCourse.setTeacher( pair.getY() );

            termCourses.add(termCourse);

        }


        term.setTermCourses(termCourses);

        newObject(term);


    }

    @Override
    public Term retrieveTermById(long id) {

        return termDao.get(id);

    }

    @Transactional(readOnly = false)
    @Override
    public void updateTerm(Term term) {
        termDao.update(term);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteTerm(Term term) {
        termDao.delete(term);
    }

    @Override
    public List<Term> listAll() {
        return termDao.listAll();
    }

}
