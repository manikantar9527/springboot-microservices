package com.persistent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.model.Course;
import com.persistent.repository.CourseRepository;
import com.persistent.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public Course getCourse(Long id) {
		return courseRepo.getById(id);
	}

	@Override
	public List<Course> getCourses() {
		return courseRepo.findAll();
	}

	@Override
	public String addCourse(Course course) {

		courseRepo.save(course);
		return AppConstants.COURSE_ADDED;
	}

	@Override
	public String addCourses(List<Course> courses) {
		courseRepo.saveAll(courses);
		return AppConstants.COURSES_ADDED;
	}

}
