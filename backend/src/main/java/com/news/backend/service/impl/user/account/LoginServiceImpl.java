package com.news.backend.service.impl.user.account;

import com.news.backend.pojo.User;
import com.news.backend.service.impl.utils.UserDetailsImpl;
import com.news.backend.service.user.account.LoginService;
import com.news.backend.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Map<String, String> getToken(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(username,password);
        //将用户名和密码封装成一个类，存密文

        Authentication authenticate = authenticationManager.authenticate(authenticationToken);//判断是否能登录，不能会自行处理

        UserDetailsImpl loginUser =(UserDetailsImpl) authenticate.getPrincipal();//登录成功后将用户取出来

        User user=loginUser.getUser();
        String jwt= JwtUtil.createJWT(user.getId().toString());   //将用户的userid封装成一个jwt——token
        Map<String,String> map=new HashMap<>();
        map.put("error_message","success");
        map.put("token",jwt);
        return  map;
    }
}
