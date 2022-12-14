package com.woniu.mapper;

import com.woniu.entity.Perms;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wdn
 * @since 2022-06-16
 */
@Mapper
public interface PermsMapper extends BaseMapper<Perms> {

    @Select("SELECT u.`username`,p.* " +
            "FROM rbac_user u " +
            "LEFT JOIN rbac_user_perm up ON u.`id`=up.`userid` " +
            "LEFT JOIN rbac_perms p ON up.`permid`=p.`id` " +
            "WHERE p.`type`='m' AND p.status='y' AND u.`username`=#{username}")
    List<Perms> listMenu(String username);

    /**
     * 获得指定用户的权限
     * @param userid
     * @return
     */
    @Select("select p.id from rbac_user_perm up " +
            "left join rbac_perms p on up.permid=p.id " +
            "where p.type='p' and userid=#{userid}")
    List<Integer> listPermsIdByUserId(Integer userid);

    /**
     * 根据用户ID删除它的权限
     * @param userid
     * @return
     */
    @Delete("delete from rbac_user_perm where userid=#{userid}")
    int deletePermsByUserId(Integer userid);

    int insertPermsByUserId(@Param("userid") Integer userid, @Param("permsids") String[] permsids);
}
