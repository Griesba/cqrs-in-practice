package com.leretvil.cqrsinpractice.repository;

import com.leretvil.cqrsinpractice.repository.domain.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EnrollmentRepository extends JpaRepository<Enrollment, UUID> {
}
