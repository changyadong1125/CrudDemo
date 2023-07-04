package com.atguigu.cruddemo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.time.LocalDate;


/**
 * project:CrudDemo
 * package:com.atguigu.cruddemo.entity
 * class:Student
 *
 * @author: smile
 * @create: 2023/6/30-22:45
 * @Version: v1.0
 * @Description:
 */
@Data
@Component
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("birthday")
    private LocalDate birthday;
    private String picture;
    private String phone;
    private String address;
    private String info;

}

