package com.news.backend.controller.user.account;


import com.news.backend.service.user.account.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;


    @PostMapping("/user/account/token/")
    private Map<String,String> getToken(@RequestParam Map<String,String>  data)
    {
        String username=data.get("username");
        String password=data.get("password");
      return   loginService.getToken(username,password);
    }

}
