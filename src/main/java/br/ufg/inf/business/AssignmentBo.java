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

@Service("AssignmentService")
public class AssignmentBo implements IAssignmentBo {

    @Autowired
    AssignmentDaoContract assignmentDao;

    @Override
    public List<Assignment> obtainByTermAndCourse(TermCourses termCourse) {
        return assignmentDao.obtainByTermAndCourse(termCourse.getTerm().getTermId(), termCourse.getCourse().getCourseId());
    }

    @Override
    public List<Assignment> obtainByTerm(Long termId) {
        return assignmentDao.obtainByTermAndCourse(termId, null);
    }

    @Override
    public void newAssignment(Assignment assignment) {
        assignmentDao.add(assignment);
    }

    @Override
    public List<Assignment> listAll() {
        return Optional.of(assignmentDao.listAll()).orElse(new ArrayList<>());
    }

    @Override
    public void delete(Assignment assignment) {
        assignmentDao.delete(assignment);
    }

    @Override
    public void edit(Assignment assignment) {
        assignmentDao.update(assignment);
    }
}
