package com.hejie.springbootpractice.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Program: springbootpractice
 * @Description: 分页插件参数配置类,进行参数设置
 * @Author: hejie
 * @Create: 2020-05-20 11:30
 */
@Configuration
public class PageHelpConfig {

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper =  new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
