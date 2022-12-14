package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wdn
 * @since 2022-06-10
 */
public interface IUserService extends IService<User> {

    public List<String> selectPermscodeByUserame(String username);

    public PageInfo<User> queryUser(String username, Integer pageNum, Integer pageSize);
}
