package com.csufg2016.business.contracts;

import com.csufg2016.entities.Teacher;

public interface ITeacherBo extends BusinessContract<Teacher> {

    void newTeacher(Teacher teacher);
    Teacher retrieveTeacherById(long id);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);


}
