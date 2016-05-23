package com.pwufg2015.business;

import com.pwufg2015.business.contracts.IStudentBo;
import com.pwufg2015.business.contracts.ITermBo;
import com.pwufg2015.dao.TermDao;
import com.pwufg2015.dao.contracts.StudentDaoContract;
import com.pwufg2015.dao.contracts.TermDaoContract;
import com.pwufg2015.entities.Student;
import com.pwufg2015.entities.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
