package com.woniu.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.entity.Teacher;
import com.woniu.entity.User;
import com.woniu.mapper.TeacherMapper;
import com.woniu.service.ITeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wdn
 * @since 2022-06-17
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public PageInfo<Teacher> queryTeacher(String teacherName, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> teacherList = teacherMapper.queryTeacher(teacherName);
        PageInfo<Teacher> pageInfo = new PageInfo<>(teacherList);

        return pageInfo;
    }
}
