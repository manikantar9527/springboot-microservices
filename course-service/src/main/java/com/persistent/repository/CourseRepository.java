package com.persistent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistent.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
