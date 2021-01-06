package com.mateuszjanczak.springdataelasticsearch.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Person {
    @Id
    String id;
    String firstname;
    String lastname;
}
