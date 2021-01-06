package com.lab.one.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.lab.one.entity.LabNews;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author simeixue
 * @date 2021/1/6
 */
public interface LabNewsMapper extends BaseMapper<LabNews> {

    List<LabNews> findNewsList(@Param("size") Integer size,
                               @Param("queryParam") String queryParam);
}
