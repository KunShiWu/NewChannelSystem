package com.news.backend.service.news;

import java.util.Map;

public interface AddNewsService {
    Map<String,String> addnews(String style,String photo,String content,String author);
}
