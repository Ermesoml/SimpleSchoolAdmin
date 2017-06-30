package br.ufg.inf.business;

import br.ufg.inf.business.contracts.ICourseBo;
import br.ufg.inf.dao.contracts.CourseDaoContract;
import br.ufg.inf.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The Class CourseBo.
 */
@Service("CourseService")
@Transactional(readOnly = true)
public class CourseBo implements ICourseBo {

	/** The course dao. */
	@Autowired
	CourseDaoContract courseDao;

	/* (non-Javadoc)
	 * @see br.ufg.inf.business.contracts.ICourseBo#newCourse(br.ufg.inf.entities.Course)
	 */
	@Override
	@Transactional(readOnly = false)
	public void newCourse(Course course) {
          courseDao.add(course);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.business.contracts.ICourseBo#retrieveCourseById(long)
	 */
	@Override
	public Course retrieveCourseById(long id) {
		return courseDao.get(id);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.business.contracts.ICourseBo#updateCourse(br.ufg.inf.entities.Course)
	 */
	@Override
	@Transactional(readOnly = false)
	public void updateCourse(Course course) {
		courseDao.update(course);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.business.contracts.ICourseBo#deleteCourse(br.ufg.inf.entities.Course)
	 */
	@Override
	@Transactional(readOnly = false)
	public void deleteCourse(Course course) {
		courseDao.delete(course);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.business.contracts.BusinessContract#listAll()
	 */
	@Override
	public List<Course> listAll() {
		return Optional.of(courseDao.listAll()).orElse(new ArrayList<>());
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.business.contracts.BusinessContract#delete(java.lang.Object)
	 */
	@Override
	public void delete(Course course) {
		courseDao.delete(course);
	}

	/* (non-Javadoc)
	 * @see br.ufg.inf.business.contracts.BusinessContract#edit(java.lang.Object)
	 */
	@Override
	public void edit(Course course) {
		courseDao.update(course);
	}
}
