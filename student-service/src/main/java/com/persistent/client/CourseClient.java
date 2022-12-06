package com.persistent.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.persistent.model.Course;

@FeignClient(name = "course-service")
public interface CourseClient {
	@GetMapping("courses")
	public List<Course> invokeCourseApi();
}
