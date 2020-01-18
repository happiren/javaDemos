package com.happiren.kafka.demo.controller;


import java.util.List;

public interface ISearchService {

    List<SearchPost> searchPostByContent(String content, int page, int count);

    boolean saveSearchPost(SearchPost target);

}
