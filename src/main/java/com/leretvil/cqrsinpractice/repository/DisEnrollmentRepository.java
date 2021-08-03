package com.leretvil.cqrsinpractice.repository;

import com.leretvil.cqrsinpractice.repository.domain.DisEnrollment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DisEnrollmentRepository extends JpaRepository<DisEnrollment, UUID> {
}
