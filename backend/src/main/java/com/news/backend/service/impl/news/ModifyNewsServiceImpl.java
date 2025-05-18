package com.news.backend.service.impl.news;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.news.backend.mapper.NewsMapper;
import com.news.backend.pojo.News;
import com.news.backend.service.news.ModifyNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ModifyNewsServiceImpl implements ModifyNewsService {


    @Autowired
    NewsMapper newsMapper;

    @Override
    public Map<String, String> modifyNews(String photo, String content,Integer id) {

        UpdateWrapper<News> updateWrapper=new UpdateWrapper<>();

        updateWrapper.eq("id",id).set("photo",photo).set("content",content);

        newsMapper.update(null,updateWrapper);

        Map<String,String > map=new HashMap<>();

        map.put("error_message","success");
        return map;
    }
}
