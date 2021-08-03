package com.leretvil.cqrsinpractice.web.controller;

import com.leretvil.cqrsinpractice.services.Messages;
import com.leretvil.cqrsinpractice.services.ServiceProvider;
import com.leretvil.cqrsinpractice.services.commands.EditPersonalInfoCommand;
import com.leretvil.cqrsinpractice.web.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping( value = "/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final Messages messages;

    @PostMapping
    public ResponseEntity editStudentInfo(){

        EditPersonalInfoCommand command = new EditPersonalInfoCommand(
                UUID.randomUUID(),
                "toto",
                "toto@thyn.com"
        );

        Result result =  messages.dispatch(command);

        return result.isSuccess() ?
                ResponseEntity.ok().build() :
                ResponseEntity.badRequest().body("Student edition failed");

    }

}
