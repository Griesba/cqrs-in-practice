package com.leretvil.cqrsinpractice.repository.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Type(type="org.hibernate.type.UUIDCharType")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false )
    private UUID id;
    private UUID studentId;
    private Grade grade;
    private String courseName;

    @Builder
    public Enrollment(UUID studentId, Grade grade, String courseName) {
        this.studentId = studentId;
        this.grade = grade;
        this.courseName = courseName;
    }

    public enum Grade {
        A, B, C, D
    }
}
