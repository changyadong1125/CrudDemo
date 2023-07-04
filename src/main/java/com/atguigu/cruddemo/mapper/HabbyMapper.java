package com.atguigu.cruddemo.mapper;

import com.atguigu.cruddemo.entity.Habby;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * project:CrudDemo
 * package:com.atguigu.cruddemo.mapper
 * class:HabbyMapper
 *
 * @author: smile
 * @create: 2023/6/30-22:50
 * @Version: v1.0
 * @Description:
 */
@SuppressWarnings("all")
public interface HabbyMapper extends BaseMapper<Habby> {
    @Select("select h.name from habby h left join student s on h.sid = s.id where s.id = #{id} ")
    List<String> findHabby(int id);

    @Delete("delete from habby where sid = #{id}")
    void removeBySid(Integer id);
}
