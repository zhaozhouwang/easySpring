package com.lab.one.config;

import com.baomidou.mybatisplus.incrementer.H2KeyGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.incrementer.OracleKeyGenerator;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.lab.one.utils.MybatisAutofillHandler;

/**
 * <p>
 * MP Config
 * </p>
 *
 * @author Mr.One
 * @date 2019-01-06
 */

@Configuration
@MapperScan("com.lab.*.mapper*")
public class MybatisPlusConfig {

    /*
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public GlobalConfiguration globalConfiguration() {
        GlobalConfiguration conf = new GlobalConfiguration();
        conf.setIdType(1);
        conf.setKeyGenerator(new H2KeyGenerator());
        conf.setMetaObjectHandler(new MybatisAutofillHandler());
        return conf;
    }

}
