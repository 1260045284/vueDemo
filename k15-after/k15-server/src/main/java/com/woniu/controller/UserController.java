package com.woniu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import com.woniu.entity.Perms;
import com.woniu.entity.Teacher;
import com.woniu.entity.User;
import com.woniu.service.IPermsService;
import com.woniu.service.IUserService;
import com.woniu.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wdn
 * @since 2022-06-10
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermsService permsService;

    @RequestMapping("/testJwt")
    public Map<String, String> testJwt() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("stu1", "张三");
        testMap.put("stu2", "李四");
        testMap.put("stu3", "王五");

        return testMap;
    }

    @RequestMapping("/list")
    public ResponseResult<Object> queryUser(String username, Integer pageNum, Integer pageSize) {
        ResponseResult<Object> responseResult = null;

        PageInfo<User> pageInfo = userService.queryUser(username, pageNum, pageSize);

        responseResult = new ResponseResult<>(pageInfo, "OK", 200);

        return responseResult;
    }

    /**
     * 获取 所有资源权限 以及 选择的用户权限
     * @return
     */
    @GetMapping("/perms")
    public ResponseResult<Object> perms(Integer userid) {
        // 获得所有的权限
        List<Perms> allPermsList = permsService.listAll();
        // 获取指定用户的权限
        List<Integer> userPermsItems = permsService.listPermsIdByUserId(userid);

        Map<String,Object> map = new HashMap<String,Object>();
        //将所有的权限添加到map中
        map.put("permsTree", allPermsList);
        //将用户的权限添加到map中
        map.put("userPermsItems", userPermsItems);

        return new ResponseResult<>(map, "OK", 200);
    }

    @GetMapping("/addperms")
    public ResponseResult<Void> addperms(Integer userid, String permsids) {

        String[] permsidArr = null;
        if(!StringUtils.isEmpty(permsids)) {
            permsidArr = permsids.split(",");
        }

        int k = permsService.insertPermsByUserId(userid, permsidArr);
        return new ResponseResult<>(200,"用户授权成功。。");
    }

}
