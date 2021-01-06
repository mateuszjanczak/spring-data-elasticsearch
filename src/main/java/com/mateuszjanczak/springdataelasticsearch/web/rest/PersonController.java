package com.mateuszjanczak.springdataelasticsearch.web.rest;

import com.mateuszjanczak.springdataelasticsearch.domain.Person;
import com.mateuszjanczak.springdataelasticsearch.repository.PersonRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping(value = "/api/create", consumes = "application/json; charset=utf-8")
    public String createPerson(@RequestBody Person person) throws IOException {
        return personRepository.indexRequest(person);
    }
}
