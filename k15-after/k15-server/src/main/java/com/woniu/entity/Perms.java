package com.woniu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wdn
 * @since 2022-06-16
 */
@Getter
@Setter
@TableName("rbac_perms")
public class Perms implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String code;

    private String link;

    private Integer parentid;

    /**
     * m:菜单 p：数据
     */
    private String type;

    /**
     * 1:正常 2：禁用
     */
    private String status;

    private String percode;

    private String icon;

    // 二级菜单列表
    @TableField(exist = false)
    private List<Perms> childerList;


}
