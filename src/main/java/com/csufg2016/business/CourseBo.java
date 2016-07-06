package com.csufg2016.business;

import com.csufg2016.business.contracts.ICourseBo;
import com.csufg2016.dao.contracts.CourseDaoContract;
import com.csufg2016.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("CourseService")
@Transactional(readOnly = true)
public class CourseBo implements ICourseBo {

	@Autowired
	CourseDaoContract courseDao;

	@Override
	@Transactional(readOnly = false)
	public void newCourse(Course course) {
          courseDao.add(course);
	}

	@Override
	public Course retrieveCourseById(long id) {
		return courseDao.get(id);
	}

	@Override
	@Transactional(readOnly = false)
	public void updateCourse(Course course) {
		courseDao.update(course);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteCourse(Course course) {
		courseDao.delete(course);
	}

	@Override
	public List<Course> listAll() {
		return Optional.of(courseDao.listAll()).orElse(new ArrayList<>());
	}
}
