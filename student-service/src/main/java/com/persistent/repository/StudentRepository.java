package com.persistent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.persistent.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
