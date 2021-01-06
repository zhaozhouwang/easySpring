package com.lab.one.service;

import com.baomidou.mybatisplus.service.IService;
import com.lab.one.entity.LabNews;

import java.util.List;

/**
 * @author simeixue
 * @date 2021/1/6
 */
public interface LabNewsService extends IService<LabNews> {


    List<LabNews> findNewsList(Integer size, String queryParam);
}
