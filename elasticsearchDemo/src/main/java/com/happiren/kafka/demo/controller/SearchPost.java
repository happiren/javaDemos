package com.happiren.kafka.demo.controller;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "searchpost")
@Data
public class SearchPost {

    private Integer id;

    @Field(type = FieldType.Text, searchAnalyzer = "ik_max_word", analyzer = "ik_smart")
    private String content;

    public SearchPost() {
    }

    public SearchPost(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

}
