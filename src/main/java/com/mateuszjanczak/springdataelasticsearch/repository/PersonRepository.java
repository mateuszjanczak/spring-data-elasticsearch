package com.mateuszjanczak.springdataelasticsearch.repository;

import com.google.gson.Gson;
import com.mateuszjanczak.springdataelasticsearch.domain.Person;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.io.IOException;

@Repository
public class PersonRepository {

    private final RestHighLevelClient client;
    private final Gson gson;

    public PersonRepository(@Qualifier("getRestClient") RestHighLevelClient client, Gson gson) {
        this.client = client;
        this.gson = gson;
    }

    public String indexRequest(final Person person) throws IOException {
        IndexRequest request = new IndexRequest("persons")
                .id(person.getId())
                .source(XContentType.JSON, gson.toJson(person));

        IndexResponse response = client.index(request, RequestOptions.DEFAULT);

        return response.getId();
    }
}
