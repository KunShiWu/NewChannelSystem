package com.news.backend.controller.comments;

import com.news.backend.pojo.Comments;
import com.news.backend.service.comments.GetCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetCommentController {
    @Autowired
    GetCommentsService getCommentsService;

    @GetMapping("/comments/get/")
    private List<Comments> getComments(@RequestParam String newsid)
    {
        return  getCommentsService.getComments(newsid);
    }
}
