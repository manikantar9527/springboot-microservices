package com.persistent.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentAndCourseResponse {
	private List<Student> students;
	private List<Course> courses;
}
