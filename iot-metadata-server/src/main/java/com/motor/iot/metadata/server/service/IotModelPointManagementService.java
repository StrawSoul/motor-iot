package com.motor.iot.metadata.server.service;

import com.motor.common.domain.PrimaryKeyProducer;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.iot.metadata.IotModelPoint;
import com.motor.iot.metadata.IotModelPointRepository;
import com.motor.iot.metadata.server.command.IotModelPointCreate;
import com.motor.iot.metadata.server.command.IotModelPointModify;
import com.motor.iot.metadata.server.command.IotModelPointSearch;
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
public class IotModelPointManagementService {

    private IotModelPointRepository iotModelPointRepository;
    private PrimaryKeyProducer primaryKeyProducer;

    public void create(Command<IotModelPointCreate> cmd) {
        IotModelPoint IotModelPoint = BeanMapperUtil.map(cmd.data(), IotModelPoint.class);
        String modelId = primaryKeyProducer.produce(IotModelPoint.class.getSimpleName());
        IotModelPoint.setId(modelId);
        CommandToEntityUtils.forInsert(cmd, IotModelPoint);
        iotModelPointRepository.insert(IotModelPoint);
    }

    public void remove(Command<String> cmd) {
        String id = Optional.of(cmd.data()).get();
        iotModelPointRepository.delete(id);
    }

    public void modify(Command<IotModelPointModify> cmd) {
        IotModelPoint IotModelPoint = BeanMapperUtil.map(cmd.data(), IotModelPoint.class);
        CommandToEntityUtils.forInsert(cmd, IotModelPoint);
        iotModelPointRepository.update(IotModelPoint);
    }

    public IotModelPoint findById(Command<String> cmd) {
        String id = Optional.of(cmd.data()).get();
        IotModelPoint IotModelPoint = iotModelPointRepository.findById(id);
        return IotModelPoint;
    }

    public PageList<IotModelPoint> search(Command<IotModelPointSearch> cmd) {
        IotModelPointSearch search = cmd.data();
        PageList<IotModelPoint> pageList = iotModelPointRepository.search(search, search.toPaging());
        return pageList;
    }
}
