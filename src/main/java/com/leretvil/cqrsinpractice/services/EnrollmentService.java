package com.leretvil.cqrsinpractice.services;

import com.leretvil.cqrsinpractice.repository.domain.Course;
import com.leretvil.cqrsinpractice.repository.domain.Enrollment;
import com.leretvil.cqrsinpractice.services.exceptions.EnrollmentException;
import com.leretvil.cqrsinpractice.web.model.EnrollmentDto;

public interface EnrollmentService {

    EnrollmentDto enroll(Enrollment enrollment);

    EnrollmentDto updateEnrollment(Enrollment enrollment) throws EnrollmentException;

    EnrollmentDto disEnroll(Enrollment enrollment);

    EnrollmentDto removeEnrolment(Enrollment enrollment);

    EnrollmentDto transfer(Enrollment enrollment, Course course);
}
