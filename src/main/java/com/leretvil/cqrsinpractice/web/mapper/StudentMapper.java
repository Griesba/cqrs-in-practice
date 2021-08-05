package com.leretvil.cqrsinpractice.web.mapper;

import com.leretvil.cqrsinpractice.repository.domain.Student;
import com.leretvil.cqrsinpractice.web.model.StudentDto;

public interface StudentMapper {

    Student dtoToStudent(StudentDto dto);

    StudentDto studentToDto(Student student);
}
