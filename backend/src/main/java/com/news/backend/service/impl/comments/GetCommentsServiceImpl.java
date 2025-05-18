package com.news.backend.service.impl.comments;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.news.backend.mapper.CommentsMapper;
import com.news.backend.pojo.Comments;
import com.news.backend.service.comments.GetCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCommentsServiceImpl implements GetCommentsService {

    @Autowired
    CommentsMapper commentsMapper;

    @Override
    public List<Comments> getComments(String newsid) {
        QueryWrapper<Comments> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("newsid",newsid);

        List<Comments> list=commentsMapper.selectList(queryWrapper);
        return list;
    }
}
