package com.news.backend.controller.news;

import com.news.backend.pojo.News;
import com.news.backend.service.news.GetSportNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetSportNewsController {

    @Autowired
    GetSportNewsService getSportNewsService;

    @GetMapping("/news/sport/")
    private List<News> getSport()
    {
    return     getSportNewsService.getSportnews();
    }
}
