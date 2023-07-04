package com.atguigu.cruddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * project:CrudDemo
 * package:com.atguigu.cruddemo.entity
 * class:Habby
 *
 * @author: smile
 * @create: 2023/6/30-22:48
 * @Version: v1.0
 * @Description:
 */
@Data
@TableName("habby")
public class Habby {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;
    private String name;
    private int sid;
}
