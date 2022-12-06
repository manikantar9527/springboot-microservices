package com.persistent.service;

import java.util.List;

import com.persistent.model.Student;

public interface StudentService {

	Student getStudent(Long id);

	List<Student> getStudents();


	String addStudent(Student student);

	String addStudents(List<Student> students);

}
