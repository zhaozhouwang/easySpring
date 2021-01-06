package com.lab.one.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.lab.one.entity.LabNews;
import com.lab.one.mapper.LabNewsMapper;
import com.lab.one.service.LabNewsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author simeixue
 * @date 2021/1/6
 */

@Service
public class LabNewsServiceImpl extends ServiceImpl<LabNewsMapper, LabNews> implements LabNewsService {

    @Override
    public List<LabNews> findNewsList(Integer size, String queryParam) {
        return baseMapper.findNewsList(size, StringUtils.isEmpty(queryParam) ? null : "%" + queryParam.trim() + "%");
    }
}
