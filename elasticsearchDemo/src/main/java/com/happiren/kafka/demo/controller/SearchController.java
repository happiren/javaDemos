package com.happiren.kafka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private ISearchService searchService;


    @RequestMapping(value = "/post", method = {RequestMethod.GET})
    public List<SearchPost> searchPost(@RequestParam("keyword") String keyword,
                                                         @RequestParam(value = "page", defaultValue = "1") int page,
                                                         @RequestParam(value = "count", defaultValue = "20") int count
                                                        ) {
        List<SearchPost> postList = searchService.searchPostByContent(keyword, page, count);
        return postList;
    }


    @RequestMapping(value = "/save", method = {RequestMethod.POST})
    public Boolean searchPost(SearchPost post) {
        boolean result = searchService.saveSearchPost(post);
        return result;
    }

}
