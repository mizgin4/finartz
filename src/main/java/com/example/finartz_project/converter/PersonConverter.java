package com.example.finartz_project.converter;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.model.Person;
import com.example.finartz_project.model.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component

public class PersonConverter {

    public Person convert(PersonDto source){
        if (source == null){
            return null;
        }
        Person person =new Person();
        person.setId(source.getId());
        person.setBirthDay(source.getBirthDay());
        person.setName(source.getName());
        person.setLastName(source.getLastName());
        person.setEmail(source.getEmail());
        person.setPassword(source.getPassword());
        return person;
    }

    public PersonDto convert(Person source) {
        if (source==null){
            return null;
        }
        PersonDto personDto= new PersonDto();
        personDto.setId(source.getId());
        personDto.setBirthDay(source.getBirthDay());
        personDto.setName(source.getName());
        personDto.setLastName(source.getLastName());
        personDto.setEmail(source.getEmail());
        personDto.setPassword(source.getPassword());
        return personDto;

    }



}
