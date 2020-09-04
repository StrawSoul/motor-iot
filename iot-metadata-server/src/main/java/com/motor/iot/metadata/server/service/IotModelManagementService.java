package com.motor.iot.metadata.server.service;

import com.motor.common.domain.PrimaryKeyProducer;
import com.motor.common.message.command.Command;
import com.motor.common.message.command.CommandToEntityUtils;
import com.motor.common.paging.PageList;
import com.motor.common.utils.BeanMapperUtil;
import com.motor.iot.metadata.IotModel;
import com.motor.iot.metadata.IotModelRepository;
import com.motor.iot.metadata.server.command.IotModelCreate;
import com.motor.iot.metadata.server.command.IotModelModify;
import com.motor.iot.metadata.server.command.IotModelSearch;
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
public class IotModelManagementService {

    private IotModelRepository iotModelRepository;
    private PrimaryKeyProducer primaryKeyProducer;

    public void create(Command<IotModelCreate> cmd) {
        IotModel iotModel = BeanMapperUtil.map(cmd.data(), IotModel.class);
        String modelId = primaryKeyProducer.produce(IotModel.class.getSimpleName());
        iotModel.setId(modelId);
        CommandToEntityUtils.forInsert(cmd, iotModel);
        iotModelRepository.insert(iotModel);
    }

    public void remove(Command<String> cmd) {
        String id = Optional.of(cmd.data()).get();
        iotModelRepository.delete(id);
    }

    public void modify(Command<IotModelModify> cmd) {
        IotModel iotModel = BeanMapperUtil.map(cmd.data(), IotModel.class);
        CommandToEntityUtils.forInsert(cmd, iotModel);
        iotModelRepository.update(iotModel);
    }

    public IotModel findById(Command<String> cmd) {
        String id = Optional.of(cmd.data()).get();
        IotModel iotModel = iotModelRepository.findById(id);
        return iotModel;
    }

    public PageList<IotModel> search(Command<IotModelSearch> cmd) {
        IotModelSearch search = cmd.data();
        PageList<IotModel> pageList = iotModelRepository.search(search, search.toPaging());
        return pageList;
    }
}
