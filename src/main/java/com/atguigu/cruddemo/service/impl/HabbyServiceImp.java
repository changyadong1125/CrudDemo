package com.atguigu.cruddemo.service.impl;

import com.atguigu.cruddemo.entity.Habby;
import com.atguigu.cruddemo.mapper.HabbyMapper;
import com.atguigu.cruddemo.service.HabbyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * project:CrudDemo
 * package:com.atguigu.cruddemo.service.impl
 * class:HabbyServiceImp
 *
 * @author: smile
 * @create: 2023/6/30-22:51
 * @Version: v1.0
 * @Description:
 */
@Service
public class HabbyServiceImp extends ServiceImpl<HabbyMapper, Habby> implements HabbyService {
}
