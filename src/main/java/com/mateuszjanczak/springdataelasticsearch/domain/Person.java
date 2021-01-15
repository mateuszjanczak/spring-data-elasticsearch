package com.mateuszjanczak.springdataelasticsearch.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Data
@Builder
@Document(indexName = "index")
public class Person implements Serializable {
    @Id
    String id;
    String firstName;
    String lastName;
}
