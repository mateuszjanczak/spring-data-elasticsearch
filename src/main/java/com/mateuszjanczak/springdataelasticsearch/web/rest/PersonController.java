package com.mateuszjanczak.springdataelasticsearch.web.rest;

import com.mateuszjanczak.springdataelasticsearch.domain.Person;
import com.mateuszjanczak.springdataelasticsearch.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(value = "/api/persons/{id}", consumes = "application/json; charset=utf-8")
    public ResponseEntity<Person> getOne(@PathVariable String id) {
        Optional<Person> persistedPerson = personService.findOne(id);
        return persistedPerson.map(person -> new ResponseEntity<>(person, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/api/persons", consumes = "application/json; charset=utf-8")
    public ResponseEntity<Iterable<Person>> getAll() {
        return new ResponseEntity<>(personService.getAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/api/persons/{id}", consumes = "application/json; charset=utf-8")
    public ResponseEntity<Person> updatePerson(@PathVariable String id, @RequestBody Person person) {
        return new ResponseEntity<>(personService.update(id, person), HttpStatus.OK);
    }

    @DeleteMapping(value = "/api/persons/{id}", consumes = "application/json; charset=utf-8")
    public ResponseEntity<Person> deletePerson(@PathVariable String id) {
        personService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
