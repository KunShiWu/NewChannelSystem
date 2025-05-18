package com.news.backend.controller.news;


import com.news.backend.pojo.News;
import com.news.backend.service.news.GetTechNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetTechNewsController {

    @Autowired
    GetTechNewsService getTechNewsService;

    @GetMapping("/news/tech/")
    private List<News> getTechnews()
    {
        return  getTechNewsService.getTechNews();
    }

}
