package com.news.backend.service.impl.news;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.news.backend.mapper.NewsMapper;
import com.news.backend.pojo.News;
import com.news.backend.service.news.GetSportNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetSportNewsServiceImpl implements GetSportNewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<News> getSportnews() {
        QueryWrapper<News> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("style","sport");
        List<News> list=newsMapper.selectList(queryWrapper);
        return list;
    }
}
