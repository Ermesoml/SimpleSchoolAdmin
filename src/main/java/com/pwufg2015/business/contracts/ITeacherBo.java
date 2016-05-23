package com.pwufg2015.business.contracts;

import com.pwufg2015.entities.Teacher;

import java.util.List;

public interface ITeacherBo extends BusinessContract<Teacher> {

    void newTeacher(Teacher teacher);
    Teacher retrieveTeacherById(long id);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);


}
