package com.mateuszjanczak.springdataelasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

@Configuration
public class ElasticsearchConfig {

    @Value( "${elasticsearch.host}" )
    private String host;

    @Value( "${elasticsearch.port}" )
    private int port;

    @Value( "${elasticsearch.scheme}" )
    private String scheme;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient getRestClient() {
        return new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, scheme)));
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchRestTemplate(getRestClient());
    }
}
