package br.ufg.inf.business;

import br.ufg.inf.Utils.Pair;
import br.ufg.inf.business.contracts.ITermBo;
import br.ufg.inf.dao.contracts.TermDaoContract;
import br.ufg.inf.entities.Teacher;
import br.ufg.inf.entities.Term;
import br.ufg.inf.entities.Course;
import br.ufg.inf.entities.TermCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    private void newObject(Term term) {
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
        return termDao.distinctListAll();
    }

    @Override
    public void delete(Term term) {
        termDao.delete(term);
    }

    @Override
    public void edit(Term term) {
        termDao.update(term);
    }

}
