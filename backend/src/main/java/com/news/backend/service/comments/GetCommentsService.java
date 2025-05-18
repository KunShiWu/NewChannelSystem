package com.news.backend.service.comments;

import com.news.backend.pojo.Comments;

import java.util.List;

public interface GetCommentsService {
    List<Comments> getComments(String newsid);
}
