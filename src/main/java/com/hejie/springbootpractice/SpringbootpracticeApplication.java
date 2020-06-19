package com.hejie.springbootpractice;

import cn.hutool.core.util.NetUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Program: springbootpractice
 * @Description: springboot启动类
 * @Author: hejie
 * @Create: 2020-05-12 17:11
 */
@SpringBootApplication
@EnableCaching
public class SpringbootpracticeApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        //SpringApplication.run(SpringbootpracticeApplication.class, args);
        //改用指定端口方式
        int port = 80;
        if (!NetUtil.isUsableLocalPort(port)) {
            System.err.printf("端口%d被占用，无法启动\n", port);
            System.exit(1);
        } else {
            new SpringApplicationBuilder(SpringbootpracticeApplication.class).properties("server.port=" + port).run(args);
        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
        return springApplicationBuilder.sources(this.getClass());
    }
}
