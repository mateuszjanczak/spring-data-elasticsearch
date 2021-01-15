package com.mateuszjanczak.springdataelasticsearch.repository;

import com.mateuszjanczak.springdataelasticsearch.domain.Person;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
}
