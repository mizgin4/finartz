package com.example.finartz_project.service.imp;

import com.example.finartz_project.controller.request.CreateMemberRequest;
import com.example.finartz_project.converter.PersonConverter;
import com.example.finartz_project.converter.PersonRequestConverter;
import com.example.finartz_project.model.Person;
import com.example.finartz_project.model.dto.PersonDto;
import com.example.finartz_project.repository.PersonRepository;
import com.example.finartz_project.service.MemberService;
import org.springframework.stereotype.Service;

@Service
public class PersonImpl implements MemberService {

    private final PersonRepository personRepository;
    private final PersonConverter personConverter;
    private final PersonRequestConverter personRequestConverter;


    public PersonImpl(PersonRepository personRepository, PersonConverter personConverter, PersonRequestConverter personRequestConverter) {
        this.personRepository = personRepository;
        this.personConverter = personConverter;
        this.personRequestConverter = personRequestConverter;


    }


    @Override
    public PersonDto createMember(CreateMemberRequest request) {
        if (personRepository.existsPeopleByEmail(request.getEmail())){
            System.out.println("Birseyler oluyor");

            return null;
        }
        else{
            Person convert = personConverter.convert(personRequestConverter.convert(request));
            Person save = personRepository.save(convert);
            PersonDto convert1 = personConverter.convert(save);
            return convert1;
        }




    }


    @Override
    public PersonDto getPersonbyId(Long id) {
        return null;
    }
}
