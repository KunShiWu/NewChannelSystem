package com.news.backend.controller.news;

import com.news.backend.service.news.AddNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddNewsController {
    @Autowired
    AddNewsService addNewsService;


    @PostMapping("/news/addnews/")
    private Map<String,String>  addNews(@RequestParam Map<String,String> data)
    {
        String style=data.get("style");
        String photo=data.get("photo");
        String content=data.get("content");
        String author=data.get("author");

        return  addNewsService.addnews(style,photo,content,author);
    }

}
