package br.ufg.inf.business.contracts;

import br.ufg.inf.entities.Teacher;
import br.ufg.inf.entities.TermCourses;

import java.util.List;

/**
 * The Interface ITeacherBo.
 */
public interface ITeacherBo extends BusinessContract<Teacher> {

    /**
     * New teacher.
     *
     * @param teacher the teacher
     */
    void newTeacher(Teacher teacher);
    
    /**
     * Retrieve teacher by id.
     *
     * @param id the id
     * @return the teacher
     */
    Teacher retrieveTeacherById(long id);
    
    /**
     * Update teacher.
     *
     * @param teacher the teacher
     */
    void updateTeacher(Teacher teacher);
    
    /**
     * Delete teacher.
     *
     * @param teacher the teacher
     */
    void deleteTeacher(Teacher teacher);
    
    /**
     * Retrieve teacher courses.
     *
     * @param teacherId the teacher id
     * @return the list
     */
    List<TermCourses> retrieveTeacherCourses(Long teacherId);

}
