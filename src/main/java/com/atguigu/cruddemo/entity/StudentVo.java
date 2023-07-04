package com.atguigu.cruddemo.entity;

import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author atguigu
 * @since 2023-06-30
 */
@Data
@Component
public class StudentVo {

    private Integer id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String picture;

    private List<String> habby;

    private String phone;

    private String address;

    private String info;

}
