package com.news.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.news.backend.pojo.Comments;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentsMapper extends BaseMapper<Comments> {
}
