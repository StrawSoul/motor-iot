package com.motor.iot.metadata.server.repository.impl;

import com.motor.common.domain.UnSupportRepository;
import com.motor.common.dsl.handler.PersistentDSLBuilders;
import com.motor.common.spring.repository.SimpleRepository;
import com.motor.iot.metadata.IotEntity;
import com.motor.iot.metadata.IotEntityPoint;
import com.motor.iot.metadata.IotEntityPointRepository;
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
public class IotEntityPointRepositoryImpl extends SimpleRepository<String, IotEntityPoint> implements IotEntityPointRepository {
    @Autowired
    public IotEntityPointRepositoryImpl(JdbcTemplate jdbcTemplate, PersistentDSLBuilders persistentDSLBuilders) {
        super("iot_entity_point", IotEntityPoint.class, jdbcTemplate, persistentDSLBuilders);
    }
}
