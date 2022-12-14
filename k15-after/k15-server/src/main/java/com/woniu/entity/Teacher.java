package com.woniu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author wdn
 * @since 2022-06-17
 */
@Getter
@Setter
@TableName("k15_teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private String education;

    private String career;

    private String isfamous;

    private Integer subjectid;

    private String status;

    @TableField(exist = false)
    private String subjectname;  // 所教课程


}
