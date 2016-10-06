package com.hzit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2016/9/26.
 */
@SpringBootApplication
@ComponentScan({"com.fc,com.hzit.service,com.hzit.controller"})
@MapperScan("com.hzit.dao.mapper")
public class StartSpring extends SpringBootServletInitializer {
//    public StartSpring(){
//        System.out.println("servlet_1类被创建了咯");
//    }
//
//    public void test1(){
//        System.out.println("这是我用springBoot框架写的第一个方法咯");
//    }

    public static void main(String[] args) {
        SpringApplication.run(StartSpring.class,args);
    }

}
