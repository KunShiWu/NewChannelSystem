package com.news.backend.controller.user.account;

import com.news.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RegisterController {
    @Autowired
    RegisterService registerService;

    @PostMapping("/user/account/register/")
    private Map<String ,String> register(@RequestParam Map<String ,String> data){
        String username=data.get("username");
        String password=data.get("password");
        String confirmPassword=data.get("confirmPassword");

        return  registerService.register(username,password,confirmPassword);
    }
}
