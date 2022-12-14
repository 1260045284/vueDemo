package com.woniu.mapper;

import com.woniu.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wdn
 * @since 2022-06-17
 */
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

    List<Teacher> queryTeacher(String teacherName);

}
