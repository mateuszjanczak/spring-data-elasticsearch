package com.mateuszjanczak.springdataelasticsearch.service;

import com.mateuszjanczak.springdataelasticsearch.domain.Person;

import java.util.Optional;

public interface PersonService {
    Iterable<Person> getAll();
    Optional<Person> findOne(String id);
    Person create(Person person);
    void delete(String id);
}
