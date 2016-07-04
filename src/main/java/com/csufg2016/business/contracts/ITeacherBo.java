package com.csufg2016.business.contracts;

import com.csufg2016.entities.Teacher;
import com.csufg2016.entities.TermCourses;

import java.util.List;

public interface ITeacherBo extends BusinessContract<Teacher> {

    void newTeacher(Teacher teacher);
    Teacher retrieveTeacherById(long id);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
    List<TermCourses> retrieveTeacherCourses(Long teacherId);

}
