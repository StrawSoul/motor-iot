package com.motor.iot.metadata.server.repository.impl;

import com.motor.common.dsl.handler.PersistentDSLBuilders;
import com.motor.common.spring.repository.SimpleRepository;
import com.motor.iot.metadata.server.command.IotEntityPointConfig;
import com.motor.iot.metadata.server.command.IotModelPointConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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
@Service
public class IotEntityPointConfigRepositoryImpl extends SimpleRepository<String, IotEntityPointConfig>  {

    @Autowired
    public IotEntityPointConfigRepositoryImpl(JdbcTemplate jdbcTemplate, PersistentDSLBuilders persistentDSLBuilders) {
        super("iot_entity_point_config", IotEntityPointConfig.class, jdbcTemplate, persistentDSLBuilders);
    }
}
