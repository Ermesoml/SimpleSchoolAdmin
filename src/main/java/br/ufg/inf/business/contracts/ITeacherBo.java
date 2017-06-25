package br.ufg.inf.business.contracts;

import br.ufg.inf.entities.Teacher;
import br.ufg.inf.entities.TermCourses;

import java.util.List;

public interface ITeacherBo extends BusinessContract<Teacher> {

    void newTeacher(Teacher teacher);
    Teacher retrieveTeacherById(long id);
    void updateTeacher(Teacher teacher);
    void deleteTeacher(Teacher teacher);
    List<TermCourses> retrieveTeacherCourses(Long teacherId);

}
