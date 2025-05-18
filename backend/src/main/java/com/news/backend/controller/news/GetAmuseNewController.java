package com.news.backend.controller.news;

import com.news.backend.pojo.News;
import com.news.backend.service.news.GetAmuseNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAmuseNewController {
    @Autowired
    GetAmuseNewsService getAmuseNewsService;

    @GetMapping("/news/getamusenews/")
    private List<News> getaumsenews(){
     return   getAmuseNewsService.getamuseNew();
    }


}
