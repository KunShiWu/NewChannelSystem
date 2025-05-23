package com.news.backend.controller.user.account;

import com.news.backend.service.user.account.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {

    @Autowired
    InfoService infoService;

    @GetMapping("/user/account/info/")
    private Map<String,String > getInfo(){
        return infoService.getInfo();
    }
}
