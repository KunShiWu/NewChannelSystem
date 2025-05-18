package com.news.backend.service.comments;

import java.util.Map;

public interface SetCommentsService {
    Map<String,String> SetComment(String newsid,String photo,String username,String content);
}
