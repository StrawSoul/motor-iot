package com.motor.iot.metadata.server.controller;

import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.common.paging.PagingRequest;
import com.motor.iot.metadata.IotModel;
import com.motor.iot.metadata.IotModelRepository;
import com.motor.iot.metadata.server.repository.mapper.IotModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
@RestController
@RequestMapping("test")
public class TestPageController {

    @Autowired
    IotModelMapper iotModelMapper;

    @Autowired
    IotModelRepository iotModelRepository;

    @GetMapping("1")
    public ResultData test1(PagingRequest pageRequest){
        Map<String,Object> map = new HashMap<>();
        map.put("minId", "2");
        PageList pageList = iotModelMapper.selectWithPage(map,pageRequest.toPaging());
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }
    @GetMapping("2")
    public ResultData test2(){
        IotModel iotModel = iotModelRepository.findById("1");
        return ResultBuilder.getInstance()
                .data(iotModel)
                .success()
                .build();
    }
}
