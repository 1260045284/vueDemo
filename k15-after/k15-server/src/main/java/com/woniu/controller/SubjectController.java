package com.woniu.controller;


import com.woniu.entity.Subject;
import com.woniu.service.ISubjectService;
import com.woniu.util.ResponseResult;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wdn
 * @since 2022-06-17
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private ISubjectService subjectService;

    @GetMapping("/list")
    public ResponseResult<Object> listSubject() {
        List<Subject> subjectList = subjectService.list();

        ResponseResult<Object> responseResult = new ResponseResult<>(subjectList, "OK", 200);
        return responseResult;
    }

}
