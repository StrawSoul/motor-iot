package com.motor.iot.metadata.server.application;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * ===========================================================================================
 * 设计说明
 * -------------------------------------------------------------------------------------------
 * <p>
 * ===========================================================================================
 * 方法简介
 * -------------------------------------------------------------------------------------------
 * {methodName}     ->  {description}
 * ===========================================================================================
 * 变更记录
 * -------------------------------------------------------------------------------------------
 * version: 0.0.0  2020/9/1 11:00  zlj
 * 创建
 * -------------------------------------------------------------------------------------------
 * version: 0.0.1  {date}       {author}
 * <p>
 * ===========================================================================================
 */
@SpringBootApplication(scanBasePackages = "com.motor.iot.metadata.server")
@ImportResource(locations = { "classpath*:/spring/*.xml"})
@EnableAutoConfiguration
@MapperScan("com.motor.iot.metadata.server.repository.mapper")
@EnableCaching
@EnableTransactionManagement
public class IotMetadataServer {
    static Logger logger = LoggerFactory.getLogger(IotMetadataServer.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(IotMetadataServer.class, args);
        logger.info("IotMetadataServer start up !!!");
    }

}

