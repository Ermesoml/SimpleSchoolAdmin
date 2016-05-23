package com.pwufg2015.business;

import com.pwufg2015.business.contracts.ICourseBo;
import com.pwufg2015.dao.contracts.CourseDaoContract;
import com.pwufg2015.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

		List<Course> courses = courseDao.listAll();

		return courses.isEmpty() ? new ArrayList<Course>() : courses;


	}
}
