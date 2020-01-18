package com.happiren.kafka.demo.controller;

import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchService implements ISearchService {

    @Autowired
    private MyElasticsearchRepository elasticsearchRepository;

    @Override
    public List<SearchPost> searchPostByContent(String content, int page, int count) {
//        var query = new NativeSearchQueryBuilder()
//                .withQuery(QueryBuilders.termQuery("content", content))
//                .withIndices("search")
//                .withTypes("objects")
//                .withPageable(PageRequest.of(page, count))
//                .build();

        NativeSearchQuery query = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("content", content))
                .withPageable(PageRequest.of(page, count))
                .build();
        List<SearchPost> result = elasticsearchRepository.search(query).getContent();
        return result;
    }

    @Override
    public boolean saveSearchPost(SearchPost target) {
        elasticsearchRepository.save(target);
        return true;
    }


}
