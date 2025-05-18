package com.news.backend.service.impl.utils;

import com.news.backend.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private User user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override

    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {//是否账号未过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {//是否账号不锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {//是否未过期
        return true;
    }

    @Override
    public boolean isEnabled() {//是否被启用
        return true;
    }
}
