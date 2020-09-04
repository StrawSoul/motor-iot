package com.motor.iot.metadata.server.service;

import com.motor.common.domain.PrimaryKeyProducer;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.iot.metadata.IotEntity;
import com.motor.iot.metadata.IotEntityRepository;
import com.motor.iot.metadata.server.command.IotEntityCreate;
import com.motor.iot.metadata.server.command.IotEntityModify;
import com.motor.iot.metadata.server.command.IotEntitySearch;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
 * version: 0.0.0  2020/9/1 09:00  zlj
 * 创建
 * -------------------------------------------------------------------------------------------
 * version: 0.0.1  {date}       {author}
 * <p>
 * ===========================================================================================
 */
@Service
public class IotEntityManagementService {

    private IotEntityRepository iotEntityRepository;
    private PrimaryKeyProducer primaryKeyProducer;

    public void create(Command<IotEntityCreate> cmd) {
        IotEntity IotEntity = BeanMapperUtil.map(cmd.data(), IotEntity.class);
        String modelId = primaryKeyProducer.produce(IotEntity.class.getSimpleName());
        IotEntity.setId(modelId);
        CommandToEntityUtils.forInsert(cmd, IotEntity);
        iotEntityRepository.insert(IotEntity);
    }

    public void remove(Command<String> cmd) {
        String id = Optional.of(cmd.data()).get();
        iotEntityRepository.delete(id);
    }

    public void modify(Command<IotEntityModify> cmd) {
        IotEntity IotEntity = BeanMapperUtil.map(cmd.data(), IotEntity.class);
        CommandToEntityUtils.forInsert(cmd, IotEntity);
        iotEntityRepository.update(IotEntity);
    }

    public IotEntity findById(Command<String> cmd) {
        String id = Optional.of(cmd.data()).get();
        IotEntity IotEntity = iotEntityRepository.findById(id);
        return IotEntity;
    }

    public PageList<IotEntity> search(Command<IotEntitySearch> cmd) {
        IotEntitySearch search = cmd.data();
        PageList<IotEntity> pageList = iotEntityRepository.search(search, search.toPaging());
        return pageList;
    }
}
