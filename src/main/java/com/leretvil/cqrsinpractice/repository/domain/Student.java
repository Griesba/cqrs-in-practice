package com.leretvil.cqrsinpractice.repository.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Student extends Person{
    private String grade;
    @OneToMany
    private List<Course> courses;

}
