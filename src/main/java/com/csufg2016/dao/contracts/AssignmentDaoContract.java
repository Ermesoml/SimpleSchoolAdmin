package com.csufg2016.dao.contracts;

import com.csufg2016.entities.Assignment;

import java.util.List;

public interface AssignmentDaoContract extends GenericDaoContract<Assignment> {

    List<Assignment> obtainByTermAndCourse(Long termId, Long courseId);

}
