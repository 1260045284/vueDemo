package com.woniu.mapper;

import com.woniu.entity.User;
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
 * @since 2022-06-10
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT p.`percode` " +
            "FROM rbac_user u " +
            "LEFT JOIN rbac_user_perm up ON u.`id`=up.`userid` " +
            "LEFT JOIN rbac_perms p ON up.`permid`=p.`id` " +
            "WHERE p.`percode` IS NOT NULL AND u.`username`=#{username}")
    public List<String> selectPermscodeByUserame(String username);

}
