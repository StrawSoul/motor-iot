package com.motor.iot.metadata.server.service;

import com.motor.common.domain.PrimaryKeyProducer;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.iot.metadata.IotEntityPoint;
import com.motor.iot.metadata.IotEntityPointRepository;
import com.motor.iot.metadata.server.command.IotEntityPointCreate;
import com.motor.iot.metadata.server.command.IotEntityPointModify;
import com.motor.iot.metadata.server.command.IotEntityPointSearch;
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
public class IotEntityPointManagementService {

    private IotEntityPointRepository iotEntityPointRepository;
    private PrimaryKeyProducer primaryKeyProducer;

    public void create(Command<IotEntityPointCreate> cmd) {
        IotEntityPoint IotEntityPoint = BeanMapperUtil.map(cmd.data(), IotEntityPoint.class);
        String modelId = primaryKeyProducer.produce(IotEntityPoint.class.getSimpleName());
        IotEntityPoint.setId(modelId);
        CommandToEntityUtils.forInsert(cmd, IotEntityPoint);
        iotEntityPointRepository.insert(IotEntityPoint);
    }

    public void remove(Command<String> cmd) {
        String id = Optional.of(cmd.data()).get();
        iotEntityPointRepository.delete(id);
    }

    public void modify(Command<IotEntityPointModify> cmd) {
        IotEntityPoint IotEntityPoint = BeanMapperUtil.map(cmd.data(), IotEntityPoint.class);
        CommandToEntityUtils.forInsert(cmd, IotEntityPoint);
        iotEntityPointRepository.update(IotEntityPoint);
    }

    public IotEntityPoint findById(Command<String> cmd) {
        String id = Optional.of(cmd.data()).get();
        IotEntityPoint IotEntityPoint = iotEntityPointRepository.findById(id);
        return IotEntityPoint;
    }

    public PageList<IotEntityPoint> search(Command<IotEntityPointSearch> cmd) {
        IotEntityPointSearch search = cmd.data();
        PageList<IotEntityPoint> pageList = iotEntityPointRepository.search(search, search.toPaging());
        return pageList;
    }
}
