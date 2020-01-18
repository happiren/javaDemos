package com.happiren.kafka.demo.controller;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MyElasticsearchRepository
        extends ElasticsearchRepository<SearchPost, Integer> {

}
