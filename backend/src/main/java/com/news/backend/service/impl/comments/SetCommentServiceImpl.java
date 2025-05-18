package com.news.backend.service.impl.comments;

import com.news.backend.mapper.CommentsMapper;
import com.news.backend.pojo.Comments;
import com.news.backend.service.comments.SetCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SetCommentServiceImpl implements SetCommentsService {

    @Autowired
    CommentsMapper commentsMapper;

    @Override
    public Map<String, String> SetComment(String newsid, String photo, String username, String content) {
      Map<String,String> map=new HashMap<>();

      Comments comments=new Comments(null,newsid,photo,username,content);

      commentsMapper.insert(comments);

      map.put("error_message","success");
      return map;

    }
}
