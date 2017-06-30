package br.ufg.inf.business;

import br.ufg.inf.business.contracts.IAssignmentBo;
import br.ufg.inf.dao.contracts.AssignmentDaoContract;
import br.ufg.inf.entities.Assignment;
import br.ufg.inf.entities.TermCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The Class AssignmentBo.
 */
@Service("AssignmentService")
public class AssignmentBo implements IAssignmentBo {

    /** The assignment dao. */
    @Autowired
    AssignmentDaoContract assignmentDao;

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IAssignmentBo#obtainByTermAndCourse(br.ufg.inf.entities.TermCourses)
     */
    @Override
    public List<Assignment> obtainByTermAndCourse(TermCourses termCourse) {
        return assignmentDao.obtainByTermAndCourse(termCourse.getTerm().getTermId(), termCourse.getCourse().getCourseId());
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IAssignmentBo#obtainByTerm(java.lang.Long)
     */
    @Override
    public List<Assignment> obtainByTerm(Long termId) {
        return assignmentDao.obtainByTermAndCourse(termId, null);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IAssignmentBo#newAssignment(br.ufg.inf.entities.Assignment)
     */
    @Override
    public void newAssignment(Assignment assignment) {
        assignmentDao.add(assignment);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#listAll()
     */
    @Override
    public List<Assignment> listAll() {
        return Optional.of(assignmentDao.listAll()).orElse(new ArrayList<>());
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#delete(java.lang.Object)
     */
    @Override
    public void delete(Assignment assignment) {
        assignmentDao.delete(assignment);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#edit(java.lang.Object)
     */
    @Override
    public void edit(Assignment assignment) {
        assignmentDao.update(assignment);
    }
}
