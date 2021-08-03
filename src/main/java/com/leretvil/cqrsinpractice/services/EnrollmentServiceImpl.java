package com.leretvil.cqrsinpractice.services;

import com.leretvil.cqrsinpractice.repository.EnrollmentRepository;
import com.leretvil.cqrsinpractice.repository.domain.Course;
import com.leretvil.cqrsinpractice.repository.domain.Enrollment;
import com.leretvil.cqrsinpractice.services.exceptions.EnrollmentException;
import com.leretvil.cqrsinpractice.web.mapper.EnrollmentMapper;
import com.leretvil.cqrsinpractice.web.model.EnrollmentDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final EnrollmentMapper enrollmentMapper;

    @Override
    public EnrollmentDto enroll(Enrollment enrollment) {
        return enrollmentMapper.enrollmentToDto(enrollmentRepository.save(enrollment));
    }

    @Override
    public EnrollmentDto updateEnrollment(Enrollment enrollment) throws EnrollmentException {
        enrollmentRepository.findById(enrollment.getId()).orElseThrow(() -> new EnrollmentException("Enrollment not found"));
        return enrollmentMapper.enrollmentToDto(enrollmentRepository.save(enrollment));
    }

    @Override
    public EnrollmentDto disEnroll(Enrollment enrollment) {
        return null;
    }

    @Override
    public EnrollmentDto removeEnrolment(Enrollment enrollment) {
        return null;
    }

    @Override
    public EnrollmentDto transfer(Enrollment enrollment, Course course) {
        return null;
    }
}
