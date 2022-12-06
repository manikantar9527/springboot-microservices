package com.persistent.service;

import java.util.List;

import com.persistent.model.Course;

public interface CourseService {

	Course getCourse(Long id);

	List<Course> getCourses();


	String addCourse(Course course);

	String addCourses(List<Course> courses);


}
