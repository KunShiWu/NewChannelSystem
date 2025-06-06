package com.news.backend.service.impl.user.account;

import com.news.backend.pojo.User;
import com.news.backend.service.impl.utils.UserDetailsImpl;
import com.news.backend.service.user.account.InfoService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class InfoServiceImpl implements InfoService {
    @Override
    public Map<String, String> getInfo() {
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();//通过密钥(id)将需要获取的用户信息提取出来

        UserDetailsImpl loginUser=(UserDetailsImpl) authentication.getPrincipal();

        User user  =loginUser.getUser();

        Map<String,String> map=new HashMap<>();

        map.put("error_message","success");
        map.put("id",user.getId().toString());
        map.put("username",user.getUsername());
        map.put("photo",user.getPhoto());
        return map;
    }
}
