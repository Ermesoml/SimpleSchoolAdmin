package com.csufg2016.business;

import com.csufg2016.business.contracts.IAssignmentBo;
import com.csufg2016.dao.contracts.AssignmentDaoContract;
import com.csufg2016.entities.Assignment;
import com.csufg2016.entities.TermCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("AssignmentService")
public class AssignmentBo implements IAssignmentBo {

    @Autowired
    AssignmentDaoContract assignment;

    @Override
    public List<Assignment> obtainByTermAndCourse(TermCourses termCourse) {
        return assignment.obtainByTermAndCourse(termCourse.getTerm().getTermId(), termCourse.getCourse().getCourseId());
    }

    @Override
    public List<Assignment> listAll() {
        return Optional.of(assignment.listAll()).orElse(new ArrayList<>());
    }
}
