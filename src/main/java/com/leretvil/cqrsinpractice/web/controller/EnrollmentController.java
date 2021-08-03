package com.leretvil.cqrsinpractice.web.controller;

import com.leretvil.cqrsinpractice.repository.domain.Enrollment;
import com.leretvil.cqrsinpractice.services.EnrollmentService;
import com.leretvil.cqrsinpractice.services.Messages;
import com.leretvil.cqrsinpractice.services.ServiceProvider;
import com.leretvil.cqrsinpractice.services.commands.EnrollStudentCommand;
import com.leretvil.cqrsinpractice.web.mapper.EnrollmentMapper;
import com.leretvil.cqrsinpractice.web.model.EnrollmentDto;
import com.leretvil.cqrsinpractice.web.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/enrollStudent/")
@RequiredArgsConstructor
public class EnrollmentController {

    private EnrollmentService enrollmentService;
    private EnrollmentMapper enrollmentMapper;
    private final Messages messages;

/*    public EnrollmentDto enroll(@RequestBody EnrollmentDto enrollmentDto) {
        return  enrollmentService.enroll(enrollmentMapper.dtoToEnrollment(enrollmentDto));
    }*/

    @PostMapping
    Result enroll(){
        EnrollStudentCommand command = new EnrollStudentCommand(UUID.randomUUID(), "Maths");

        return messages.dispatch(command);
    }
}
