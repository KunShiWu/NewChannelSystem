package com.news.backend.controller.news;

import com.news.backend.service.news.DeleteNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DeleteNewsController {
    @Autowired
    DeleteNewsService deleteNewsService;

    @PostMapping("/news/delete/")
    private Map<String,String> deleteNews(@RequestParam String id)
    {
        Integer Id=Integer.parseInt(id);
        return deleteNewsService.deleteNews(Id);

    }
}
