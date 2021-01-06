package com.lab.one.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lab.one.entity.LabNews;
import com.lab.one.mapper.LabNewsMapper;
import com.lab.one.service.LabNewsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangzhaozhou
 * @date 2021/1/6
 */

@Service
public class LabNewsServiceImpl extends ServiceImpl<LabNewsMapper, LabNews> implements LabNewsService {

    @Override
    public List<LabNews> findNewsList() {
        return selectList(new EntityWrapper<>());
    }
}
