package com.lab.one.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * <p>
 * SwaggerConfig
 * </p>
 *
 * @author wangzhaozhou
 * @date 2019-01-06
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 在配置文件中配置一个swagger开关
     */
    //@Value("${swagger.enable}")
    //private boolean enableSwagger;

    /**
     * 研发测试地址(主要是给前端看的)
     */
    private final String SIT = "192.168.10.253";

    /**
     * 本地地址(自测用)
     */
    private final String SIT_LINUX = "127.0.0.1";


    @Bean
    public Docket docket() {
        String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfo("ONE API",
                "Springboot + Mybatis Plus + Swagger 整合搭建",
                "1.0",
                "",
                new Contact("Lab", "", ""),
                "Mr.One",
                "https://github.com/wang137700/start"
                , new ArrayList<>()
        );
    }

}
