package com.news.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.news.backend.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
