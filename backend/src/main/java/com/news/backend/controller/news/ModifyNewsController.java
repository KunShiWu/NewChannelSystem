package com.news.backend.controller.news;

import com.news.backend.service.news.ModifyNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ModifyNewsController {
    @Autowired
    ModifyNewsService modifyNewsService;

    @PostMapping("/news/modify/")
    private Map<String ,String > modifynews(@RequestParam Map<String,String> data)
    {
        String photo=data.get("photo");
        String content=data.get("content");
        Integer id=Integer.parseInt(data.get("id"));

        return modifyNewsService.modifyNews(photo,content,id);
    }

}
