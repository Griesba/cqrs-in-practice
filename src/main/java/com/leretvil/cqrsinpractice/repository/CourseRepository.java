package com.leretvil.cqrsinpractice.repository;

import com.leretvil.cqrsinpractice.repository.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
