package com.mateuszjanczak.springdataelasticsearch.web.rest;

import com.mateuszjanczak.springdataelasticsearch.domain.Person;
import com.mateuszjanczak.springdataelasticsearch.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(value = "/api/persons", consumes = "application/json; charset=utf-8")
    public ResponseEntity<Person> insertPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.create(person), HttpStatus.OK);
    }

    @GetMapping(value = "/api/persons", consumes = "application/json; charset=utf-8")
    public ResponseEntity<Iterable<Person>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }
}
