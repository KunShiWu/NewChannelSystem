package com.news.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.news.backend.pojo.News;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewsMapper extends BaseMapper<News> {
}
