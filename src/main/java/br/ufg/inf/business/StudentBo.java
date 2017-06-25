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

@Service("StudentService")
@Transactional(readOnly = true)
public class StudentBo implements IStudentBo {

    @Autowired
    StudentDaoContract studentDao;

    @Autowired
    ITermBo termBo;

    @Override
    @Transactional(readOnly = false)
    public void enrollStudent(Student student) {
        studentDao.add(student);
    }

    @Override
    public List<TermCourses> getEnrolledCourses(Long studentId) {

        Student student = studentDao.get(studentId);
        return Optional.of(studentDao.getEnrolledCourses(student.getTermEnrolled().getTermId()))
                .orElse(new ArrayList<>());

    }

    @Override
    public Student retrieveStudentById(long id) {
        return studentDao.get(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDao.update(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentDao.delete(student);
    }

    @Override
    public List<Student> listAll() {
        return studentDao.listAll();
    }

    @Override
    public void delete(Student student) {
        studentDao.delete(student);
    }

    @Override
    public void edit(Student student) {
        studentDao.update(student);
    }
}
