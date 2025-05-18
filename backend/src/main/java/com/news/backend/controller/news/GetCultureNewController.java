package com.news.backend.controller.news;

import com.news.backend.pojo.News;
import com.news.backend.service.news.GetCultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetCultureNewController {

    @Autowired
    GetCultureService getCultureService;

    @GetMapping("/news/getculture/")
    private List<News> getCulture(){
        return getCultureService.getCulture();
    }


}
