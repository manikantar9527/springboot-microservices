package com.persistent.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.persistent.client.CourseClient;
import com.persistent.model.Course;
import com.persistent.model.Student;
import com.persistent.model.StudentAndCourseResponse;
import com.persistent.service.StudentService;

@RestController
public class StudentController {

	private Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	private CourseClient courseClient;
	

	@GetMapping("/students/courses")
	public ResponseEntity<StudentAndCourseResponse> getStudentsWithCourses() {
		logger.info("Request received");
		List<Course> courses = courseClient.invokeCourseApi();
		logger.info("Request completed");
		return ResponseEntity.ok(new StudentAndCourseResponse(getStudents().getBody(), courses));
	}

	@Autowired
	private StudentService studentService;

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {
		return ResponseEntity.ok(studentService.getStudents());
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable long id) {
		return ResponseEntity.ok(studentService.getStudent(id));
	}

	@PutMapping("/update/student")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.addStudent(student));
	}

	@PostMapping("/add/student")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		return ResponseEntity.ok(studentService.addStudent(student));
	}

	@PostMapping("/add/students")
	public ResponseEntity<String> addStudents(@RequestBody List<Student> students) {
		return ResponseEntity.ok(studentService.addStudents(students));
	}
}
