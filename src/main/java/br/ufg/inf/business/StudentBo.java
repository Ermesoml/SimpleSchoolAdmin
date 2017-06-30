package br.ufg.inf.business;

import br.ufg.inf.business.contracts.IStudentBo;
import br.ufg.inf.business.contracts.ITermBo;
import br.ufg.inf.dao.contracts.StudentDaoContract;
import br.ufg.inf.entities.Student;
import br.ufg.inf.entities.TermCourses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The Class StudentBo.
 */
@Service("StudentService")
@Transactional(readOnly = true)
public class StudentBo implements IStudentBo {

    /** The student dao. */
    @Autowired
    StudentDaoContract studentDao;

    /** The term bo. */
    @Autowired
    ITermBo termBo;

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IStudentBo#enrollStudent(br.ufg.inf.entities.Student)
     */
    @Override
    @Transactional(readOnly = false)
    public void enrollStudent(Student student) {
        studentDao.add(student);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IStudentBo#getEnrolledCourses(java.lang.Long)
     */
    @Override
    public List<TermCourses> getEnrolledCourses(Long studentId) {

        Student student = studentDao.get(studentId);
        return Optional.of(studentDao.getEnrolledCourses(student.getTermEnrolled().getTermId()))
                .orElse(new ArrayList<>());

    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IStudentBo#retrieveStudentById(long)
     */
    @Override
    public Student retrieveStudentById(long id) {
        return studentDao.get(id);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IStudentBo#updateStudent(br.ufg.inf.entities.Student)
     */
    @Override
    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.IStudentBo#deleteStudent(br.ufg.inf.entities.Student)
     */
    @Override
    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#listAll()
     */
    @Override
    public List<Student> listAll() {
        return studentDao.listAll();
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#delete(java.lang.Object)
     */
    @Override
    public void delete(Student student) {
        studentDao.delete(student);
    }

    /* (non-Javadoc)
     * @see br.ufg.inf.business.contracts.BusinessContract#edit(java.lang.Object)
     */
    @Override
    public void edit(Student student) {
        studentDao.update(student);
    }
}
