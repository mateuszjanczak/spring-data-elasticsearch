package com.mateuszjanczak.springdataelasticsearch.config;

import com.google.gson.Gson;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    public Gson getGson(){
        return new Gson();
    }
}
