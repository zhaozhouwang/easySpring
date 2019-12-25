package com.lab.one.service;


import com.baomidou.mybatisplus.service.IService;
import com.lab.one.entity.RsXmax;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yuxiaobin123
 * @since 2019-12-25
 */
public interface RsXmaxService extends IService<RsXmax> {

    Integer getNextNumByType(String type);

}
