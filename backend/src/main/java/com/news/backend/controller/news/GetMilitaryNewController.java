package com.news.backend.controller.news;

import com.news.backend.pojo.News;
import com.news.backend.service.news.GetMilitaryNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetMilitaryNewController {

    @Autowired
    GetMilitaryNewsService getMilitaryNewsService;


    @GetMapping("/news/getmilitary/")
    private List<News> getmilitary(){
        return  getMilitaryNewsService.getmilitary();
    }
}
