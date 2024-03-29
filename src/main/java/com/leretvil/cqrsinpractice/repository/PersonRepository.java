package com.leretvil.cqrsinpractice.repository;

import com.leretvil.cqrsinpractice.repository.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonRepository extends JpaRepository<Person, UUID> {
}
