package com.news.backend.service.impl.news;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.news.backend.mapper.NewsMapper;
import com.news.backend.pojo.News;
import com.news.backend.service.news.GetTechNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTechNewsServiceImpl  implements GetTechNewsService {

    @Autowired
    NewsMapper newsMapper;

    @Override
    public List<News> getTechNews() {
        QueryWrapper<News> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("style","tech");
        List<News> list=newsMapper.selectList(queryWrapper);
        return list;
    }
}
