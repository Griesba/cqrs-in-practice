package com.leretvil.cqrsinpractice.services.queries;

import com.leretvil.cqrsinpractice.web.model.StudentDto;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class GetListQuery implements Query<List<StudentDto>> {

    private String courseName;
    private int numberOfCourse;

    @Builder
    public GetListQuery(String courseName, int numberOfCourse) {
        this.courseName = courseName;
        this.numberOfCourse = numberOfCourse;
    }

    @Override
    public String getType(){
        return "GetListQueryHandler";
    }
}
