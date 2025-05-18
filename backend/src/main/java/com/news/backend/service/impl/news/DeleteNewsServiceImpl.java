package com.news.backend.service.impl.news;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.news.backend.mapper.CommentsMapper;
import com.news.backend.mapper.NewsMapper;
import com.news.backend.pojo.Comments;
import com.news.backend.pojo.News;
import com.news.backend.service.news.DeleteNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeleteNewsServiceImpl implements DeleteNewsService {


    @Autowired
    NewsMapper newsMapper;

    @Autowired
    CommentsMapper commentsMapper;
    @Override
    public Map<String, String> deleteNews(Integer id) {

        Map<String,String> map=new HashMap<>();
        QueryWrapper<News> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        newsMapper.delete(queryWrapper);

        QueryWrapper<Comments> queryWrapper1=new QueryWrapper<>();
        queryWrapper1.eq("newsid",id);
        commentsMapper.delete(queryWrapper1);
        map.put("error_message","success");
        return map;
    }
}
