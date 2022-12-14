package com.woniu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.entity.Teacher;
import com.woniu.entity.User;
import com.woniu.mapper.UserMapper;
import com.woniu.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wdn
 * @since 2022-06-10
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<String> selectPermscodeByUserame(String username) {
        return userMapper.selectPermscodeByUserame(username);
    }

    @Override
    public PageInfo<User> queryUser(String username, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(username)) {
            queryWrapper.like("username", username);
        }
        queryWrapper.orderByDesc("id");
        List<User> userList = userMapper.selectList(queryWrapper);

        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo;
    }
}
