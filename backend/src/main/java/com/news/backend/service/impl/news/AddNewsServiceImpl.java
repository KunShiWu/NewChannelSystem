package com.news.backend.service.impl.news;

import com.news.backend.mapper.NewsMapper;
import com.news.backend.pojo.News;
import com.news.backend.service.news.AddNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class AddNewsServiceImpl implements AddNewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public Map<String, String> addnews(String style, String photo, String content, String author) {

        Map<String,String> map=new HashMap<>();

        News news=new News(null,style,photo,content,author);

        newsMapper.insert(news);
        map.put("error_message","success");
        return map;
    }
}
