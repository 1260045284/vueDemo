package com.woniu.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(HttpServletRequest request) {

        ServletContext sc = request.getServletContext();
        System.out.println(sc.getClass());

        sc.getFilterRegistrations().forEach((k, v) -> {
            System.out.print(k);
            System.out.print("  ---------->  ");
            System.out.println(v);
        });

        return  "hello";
    }

    @RequestMapping("/error1")
    public void error1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");

        AuthenticationException exception = (AuthenticationException) request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        response.getWriter().write(exception.toString());
    }

    /**
     * 主页面
     * @return
     */
    @GetMapping("/home")
    @PreAuthorize("hasAuthority('aaa')")
    public String home(){
        return "home";
    }

    /**
     * 用户管理
     * @return
     */
    @GetMapping("/users")
    public String users(){
        return "users";
    }

    /**
     * 角色管理
     * @return
     */
    @GetMapping("/roles")
    public String roles(){
        return "roles";
    }

    /**
     * 菜单管理
     * @return
     */
    @GetMapping("/menus")
    public String menus(){
        return "menus";
    }

    /**
     * 其他管理
     * @return
     */
    @GetMapping("/others")
    public String others(){
        return "others";
    }
}
