package com.woniu.service;

import com.woniu.entity.Perms;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wdn
 * @since 2022-06-16
 */
public interface IPermsService extends IService<Perms> {

    List<Perms> listMenu(String username);

    List<Perms> listAll();

    List<Integer> listPermsIdByUserId(Integer userid);

    public int insertPermsByUserId(Integer userid, String[] permsids);
}
