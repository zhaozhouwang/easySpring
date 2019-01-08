package com.lab.one.utils;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.lab.one.entity.base.BaseEntity;

/**
 * <p>
 * mybatis plus字段自动插入handler
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019/1/8
 */
public class MybatisAutofillHandler extends MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        if (getFieldValByName(BaseEntity.CREATE_BY_FIELD, metaObject) == null) {
            //todo 暂未加入当前用户管理
            //String userId = ContextUserHolder.getCurrentUserId();
            String userId = "test";
            //如果当前用户未获取到则塞入固定id
            this.setFieldValByName(BaseEntity.CREATE_BY_FIELD, userId, metaObject);
            if (getFieldValByName(BaseEntity.CREATE_TIME_FIELD, metaObject) == null) {
                this.setFieldValByName(BaseEntity.CREATE_TIME_FIELD, new Date(), metaObject);
                this.setFieldValByName(BaseEntity.DEL_FLAG_FIELD, 0, metaObject);
                this.setFieldValByName(BaseEntity.UPDATE_BY_FIELD, getFieldValByName(BaseEntity.CREATE_BY_FIELD, metaObject), metaObject);
                this.setFieldValByName(BaseEntity.UPDATE_TIME_FIELD, new Date(), metaObject);
            }

        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //todo 暂未加入当前用户管理
        // String userId = ContextUserHolder.getCurrentUserId();
        String userId = "test";
        this.setFieldValByName(BaseEntity.UPDATE_BY_FIELD, userId, metaObject);
        this.setFieldValByName(BaseEntity.UPDATE_TIME_FIELD, new Date(), metaObject);

    }
}
