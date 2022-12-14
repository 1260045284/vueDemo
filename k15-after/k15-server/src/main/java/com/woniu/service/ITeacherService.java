package com.woniu.service;

import com.github.pagehelper.PageInfo;
import com.woniu.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wdn
 * @since 2022-06-17
 */
public interface ITeacherService extends IService<Teacher> {

    public PageInfo<Teacher> queryTeacher(String teacherName, Integer pageNum, Integer pageSize);

}
