package com.lmsf.spring_batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lmsf.spring_batch.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
