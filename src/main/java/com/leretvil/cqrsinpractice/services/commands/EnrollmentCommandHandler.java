package com.leretvil.cqrsinpractice.services.commands;

import com.leretvil.cqrsinpractice.repository.EnrollmentRepository;
import com.leretvil.cqrsinpractice.repository.domain.Enrollment;
import com.leretvil.cqrsinpractice.web.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("EnrollStudent")
@RequiredArgsConstructor
public class EnrollmentCommandHandler implements CommandHandler<EnrollStudentCommand> {

    private final EnrollmentRepository enrollmentRepository;
    @Override
    public Result handle(EnrollStudentCommand command) {
        Enrollment enrollment = Enrollment.builder()
                .studentId(command.getStudentId())
                .grade(Enrollment.Grade.A)
                .courseName(command.getCourseName())
                .build();

        enrollmentRepository.save(enrollment);
        return new Result();
    }
}
