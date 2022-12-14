package com.woniu.service.impl;

import com.woniu.entity.Perms;
import com.woniu.mapper.PermsMapper;
import com.woniu.service.IPermsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wdn
 * @since 2022-06-16
 */
@Service
public class PermsServiceImpl extends ServiceImpl<PermsMapper, Perms> implements IPermsService {
    @Autowired
    private PermsMapper permsMapper;

    @Override
    public List<Perms> listMenu(String username) {
        // 查出来所有的菜单
        List<Perms> permsList = permsMapper.listMenu(username);

        // 一级菜单
        List<Perms> rootMenu = new ArrayList<>();

        // 找出所有的一级菜单
        for(Perms perms : permsList) {
            if(perms.getParentid() == null) {
                rootMenu.add(perms);
            }
        }

        // 后续可以优化
        // 循环一级菜单，提炼二级菜单
        for(Perms root : rootMenu) {
            // 二级菜单
            List<Perms> childerList = new ArrayList<>();
            // 从所有菜单数据中找二级菜单
            for (Perms child : permsList) {
                if(child.getParentid() == root.getId()) {
                    childerList.add(child);
                }
            }
            // 将二级菜单保存到对应的一级菜单中
            root.setChilderList(childerList);
        }

        return rootMenu;
    }

    /**
     * 查询所有的资源, 并按树结构返回
     * @return
     */
    @Override
    public List<Perms> listAll() {
        // 获取所有资源list
        List<Perms> permsList = this.list();

        List<Perms> rootPermList = new ArrayList<>();   // 定义一级菜单列表
        Map<Integer, Perms> permsMap = new HashMap<>(); // 定义一个map, 存放所有资源 id -> Perms

        permsList.forEach(perms -> {
            //  如果父ID为null，则为一级菜单
            if(perms.getParentid() == null) {
                rootPermList.add(perms);
            }
            // 把资源实体对象全部放入map
            permsMap.put(perms.getId(), perms);
            // 对所有 perms 初始化 childerList
            perms.setChilderList(new ArrayList<>());
        });
        permsList.forEach(perms -> {
            if(perms.getParentid() != null) {
                Integer parentId = perms.getParentid();
                Perms parentPerms = permsMap.get(parentId);
                List<Perms> childerList = parentPerms.getChilderList();
                childerList.add(perms);
            }
        });
        return rootPermList;
    }

    /**
     * 查询当前用户Id 它的查询资源
     * @param userid
     * @return
     */
    @Override
    public List<Integer> listPermsIdByUserId(Integer userid) {
        return permsMapper.listPermsIdByUserId(userid);
    }

    @Override
    public int insertPermsByUserId(Integer userid, String[] permsids) {
        permsMapper.deletePermsByUserId(userid);

        int n = 0;
        if(permsids != null) {
            n = permsMapper.insertPermsByUserId(userid, permsids);
        }
        return n;
    }
}
