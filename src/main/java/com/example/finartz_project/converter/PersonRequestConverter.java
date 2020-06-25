package com.example.finartz_project.converter;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.model.Person;
import com.example.finartz_project.model.dto.PersonDto;
import org.springframework.stereotype.Component;

@Component
public class PersonRequestConverter {


   public PersonDto convert(CreateMemberRequest request){
       PersonDto personDto = new PersonDto();
       personDto.setBirthDay(request.getBirthDay());
       personDto.setName(request.getName());
       personDto.setLastName(request.getLastName());
       personDto.setEmail(request.getEmail());
       personDto.setPassword(request.getPassword());

       return personDto;

   }
}
