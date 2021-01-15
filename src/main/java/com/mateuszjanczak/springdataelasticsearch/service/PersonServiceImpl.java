package com.mateuszjanczak.springdataelasticsearch.service;

import com.mateuszjanczak.springdataelasticsearch.domain.Person;
import com.mateuszjanczak.springdataelasticsearch.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Iterable<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> findOne(String id) {
        return personRepository.findById(id);
    }

    @Override
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(String id) {
        personRepository.deleteById(id);
    }
}
