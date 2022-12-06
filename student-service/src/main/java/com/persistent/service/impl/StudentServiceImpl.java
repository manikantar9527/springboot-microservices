package com.persistent.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.model.Student;
import com.persistent.repository.StudentRepository;
import com.persistent.service.StudentService;
import com.persistent.util.AppConstants;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository StudentRepo;

	@Override
	public Student getStudent(Long id) {
		return StudentRepo.getById(id);
	}

	@Override
	public List<Student> getStudents() {
		return StudentRepo.findAll();
	}

	@Override
	public String addStudent(Student Student) {

		StudentRepo.save(Student);
		return AppConstants.STUDENT_ADDED;
	}

	@Override
	public String addStudents(List<Student> students) {
		StudentRepo.saveAll(students);
		return AppConstants.STUDENTS_ADDED;
	}


}
