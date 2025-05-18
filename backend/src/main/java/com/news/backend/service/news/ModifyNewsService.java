package com.news.backend.service.news;

import java.util.Map;

public interface ModifyNewsService {
    Map<String,String> modifyNews(String photo,String  content,Integer id);
}
