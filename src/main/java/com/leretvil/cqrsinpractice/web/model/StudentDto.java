package com.leretvil.cqrsinpractice.web.model;

import lombok.Data;

import java.util.List;

@Data
public class StudentDto {
    private String name;
    private List<CourseDto> courses;
}
