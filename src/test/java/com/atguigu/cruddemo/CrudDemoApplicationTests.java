package com.atguigu.cruddemo;

import com.atguigu.cruddemo.entity.Habby;
import com.atguigu.cruddemo.mapper.HabbyMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class CrudDemoApplicationTests {
@Resource
    HabbyMapper habbyMapper ;
    @Test
    void contextLoads() {
        List<Habby> habbies =
                habbyMapper.selectList(null);
        System.out.println(habbies.toString());
    }

}
