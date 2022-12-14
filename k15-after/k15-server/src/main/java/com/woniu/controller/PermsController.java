package com.woniu.controller;


import com.woniu.entity.Perms;
import com.woniu.service.IPermsService;
import com.woniu.util.JwtTokenUtil;
import com.woniu.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wdn
 * @since 2022-06-16
 */
@RestController
@RequestMapping("/perms")
public class PermsController {

    @Autowired
    private IPermsService permsService;

    @GetMapping("/menu")
    public ResponseResult<List<Perms>> menuItem(HttpServletRequest request) {
        // 获取请求头中的token
        String token = request.getHeader("token");
        // 解析出token的用户名
        String username = JwtTokenUtil.getUsername(token);

        List<Perms> permsList = permsService.listMenu(username);

        ResponseResult<List<Perms>> responseResult = new ResponseResult<>();
        if(permsList.size() > 0) {
            responseResult.setData(permsList);
            responseResult.setStatus(200);
            responseResult.setMsg("OK");
        } else {
            responseResult.setStatus(4001);
            responseResult.setMsg("该用户没有可用菜单，请联系管理员");
        }
        return responseResult;
    }

}
