package com.woniu.config.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.woniu.entity.User;
import com.woniu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", username);
        User user = userService.getOne(wrapper);
        if(user == null) { // 证明没有这个用户
            throw new UsernameNotFoundException("用户不存在");
        }
        //如果用户存在，则还要比较密码
        String password = user.getPassword(); // 数据库存储的密码

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        // 基于用户名查询用户的权限集合
        List<String> permcodeList = userService.selectPermscodeByUserame(username);
        permcodeList.forEach(permcode -> {
            grantedAuthorityList.add(new SimpleGrantedAuthority(permcode));
        });
        return new org.springframework.security.core.userdetails.User(username, password, grantedAuthorityList);
    }
}
