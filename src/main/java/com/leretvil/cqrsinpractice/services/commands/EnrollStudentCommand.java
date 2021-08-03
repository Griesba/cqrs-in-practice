package com.leretvil.cqrsinpractice.services.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollStudentCommand implements Command {

    private UUID studentId;
    private String courseName;

    @Override
    public String getType() {
        return "EnrollStudent";
    }
}
