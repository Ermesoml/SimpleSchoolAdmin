package com.csufg2016.business.contracts;

import com.csufg2016.entities.Assignment;
import com.csufg2016.entities.TermCourses;

import java.util.List;

public interface IAssignmentBo extends BusinessContract<Assignment> {

    List<Assignment> obtainByTermAndCourse(TermCourses termCourse);

    void newAssignment(Assignment assignment);

}
