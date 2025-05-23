package com.news.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.news.backend.mapper.UserMapper;
import com.news.backend.pojo.User;
import com.news.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Map<String, String> register(String username, String password, String confirmPassword) {
        Map<String,String> map =new HashMap<>();

        if(username==null)
        {
            map.put("error_message","用户名不能为空");
            return map;
        }
        if(password==null||confirmPassword==null){
            map.put("error_message","密码不能为空");
            return  map;
        }
        username.trim();
        if(username.length()==0)
        {
            map.put("error_message","用户名不能为空");
            return map;
        }
        if(password.length()==0||confirmPassword.length()==0)
        {
            map.put("error_message","密码不能为空");
            return  map;
        }
        if(!password.equals(confirmPassword))
        {
            map.put("error_message","设定的密码不一致");
            return  map;
        }
        if(username.length()>100)
        {
            map.put("error_message","用户名过长");
            return  map;
        }
        if(password.length()>100||confirmPassword.length()>100)
        {
            map.put("error_message","密码过长");
            return map;
        }
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("username",username);

        List<User> users= userMapper.selectList(queryWrapper);
        if(!users.isEmpty())
        {
            map.put("error_message","用户名已存在");
            return map;
        }
        String encodedPassword = passwordEncoder.encode(password);

        String photo = "https://img.wxcha.com/m00/21/32/187b6676378e5bcfe15cd58cea0aa7f3.jpg";

        User user =new User(null,username,encodedPassword,photo);

        userMapper.insert(user);

        map.put("error_message","success");
        return map;



    }
}
