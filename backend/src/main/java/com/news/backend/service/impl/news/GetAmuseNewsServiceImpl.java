package com.news.backend.service.impl.news;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.news.backend.mapper.NewsMapper;
import com.news.backend.pojo.News;
import com.news.backend.service.news.GetAmuseNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GetAmuseNewsServiceImpl implements GetAmuseNewsService {

    @Autowired
    NewsMapper newsMapper;


    @Override
    public List<News> getamuseNew() {

        QueryWrapper<News> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("style","amuse");
        List<News> list=newsMapper.selectList(queryWrapper);
        return list;
    }
}
