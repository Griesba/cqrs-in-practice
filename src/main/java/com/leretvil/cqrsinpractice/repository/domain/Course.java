package com.leretvil.cqrsinpractice.repository.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    private String name;
    private int credit;

    @Builder
    public Course(String name, int credit) {
        this.name = name;
        this.credit = credit;
    }
}
