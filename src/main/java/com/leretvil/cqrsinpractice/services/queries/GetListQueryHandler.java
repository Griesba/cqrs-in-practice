package com.leretvil.cqrsinpractice.services.queries;

import com.leretvil.cqrsinpractice.repository.StudentRepository;
import com.leretvil.cqrsinpractice.web.mapper.StudentMapper;
import com.leretvil.cqrsinpractice.web.model.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service("GetListQueryHandler")
public class GetListQueryHandler implements QueryHandler<GetListQuery, List<StudentDto>> {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> handle(GetListQuery query) {
        return studentRepository.findAll().stream()
                .filter(student -> student.getCourses().contains(query.getCourseName()))
                .map(studentMapper::studentToDto).collect(Collectors.toList());
    }
}
