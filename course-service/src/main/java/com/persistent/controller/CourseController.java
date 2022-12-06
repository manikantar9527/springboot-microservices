package com.persistent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.persistent.model.Course;
import com.persistent.service.CourseService;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourses() {
		return ResponseEntity.ok(courseService.getCourses());
	}

	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable long id) {
		return ResponseEntity.ok(courseService.getCourse(id));
	}

	@PutMapping("/update/course")
	public ResponseEntity<String> updateCourse(@RequestBody Course course) {
		return ResponseEntity.ok(courseService.addCourse(course));
	}

	@PostMapping("/add/course")
	public ResponseEntity<String> addCourse(@RequestBody Course course) {
		return ResponseEntity.ok(courseService.addCourse(course));
	}
	
	
	@PostMapping("/add/courses")
	public ResponseEntity<String> addCourses(@RequestBody List<Course> courses) {
		return ResponseEntity.ok(courseService.addCourses(courses));
	}
}
