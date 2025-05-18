package com.news.backend.controller.comments;

import com.news.backend.service.comments.SetCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SetCommentController {

    @Autowired
    SetCommentsService setCommentsService;

    @PostMapping("/comments/add/")
    private Map<String,String> SetComments(@RequestParam Map<String,String> data)
    {
        String newsid=data.get("newsid");
        String photo=data.get("photo");
        String username=data.get("username");
        String content=data.get("content");

        return setCommentsService.SetComment(newsid,photo,username,content);
    }

}
