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

/**
 * The Class TermBo.
 */
@Service("TermService")
@Transactional(readOnly = true)
public class TermBo implements ITermBo {

    /** The term dao. */
    @Autowired
    TermDaoContract termDao;

    /**
     * New object.
     *
     * @param term the term
     */
    @Transactional(readOnly = false)
    private void newObject(Term term) {
        termDao.add(term);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.ITermBo#newTerm(br.ufg.inf.entities.Term, java.util.List)
     */
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

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.ITermBo#retrieveTermById(long)
     */
    @Override
    public Term retrieveTermById(long id) {
        return termDao.get(id);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.ITermBo#updateTerm(br.ufg.inf.entities.Term)
     */
    @Transactional(readOnly = false)
    @Override
    public void updateTerm(Term term) {
        termDao.update(term);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.ITermBo#deleteTerm(br.ufg.inf.entities.Term)
     */
    @Transactional(readOnly = false)
    @Override
    public void deleteTerm(Term term) {
        termDao.delete(term);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#listAll()
     */
    @Override
    public List<Term> listAll() {
        return termDao.distinctListAll();
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#delete(java.lang.Object)
     */
    @Override
    public void delete(Term term) {
        termDao.delete(term);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#edit(java.lang.Object)
     */
    @Override
    public void edit(Term term) {
        termDao.update(term);
    }

}
