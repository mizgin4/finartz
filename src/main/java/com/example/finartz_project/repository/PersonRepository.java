package com.example.finartz_project.repository;

import com.example.finartz_project.model.Person;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {


    boolean existsPeopleByEmail(String email);
}
