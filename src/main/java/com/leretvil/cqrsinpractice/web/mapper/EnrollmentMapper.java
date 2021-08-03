package com.leretvil.cqrsinpractice.web.mapper;


import com.leretvil.cqrsinpractice.repository.domain.Enrollment;
import com.leretvil.cqrsinpractice.web.model.EnrollmentDto;
import org.mapstruct.Mapper;

@Mapper
public interface EnrollmentMapper {
    EnrollmentDto enrollmentToDto(Enrollment enrollment);
    Enrollment dtoToEnrollment(EnrollmentDto enrollmentDto);
}
