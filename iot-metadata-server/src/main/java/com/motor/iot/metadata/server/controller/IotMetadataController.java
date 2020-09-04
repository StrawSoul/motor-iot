package com.motor.iot.metadata.server.controller;

import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.common.paging.PagingRequest;
import com.motor.iot.metadata.IotEntity;
import com.motor.iot.metadata.IotPoint;
import com.motor.iot.metadata.server.service.IotMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
 * version: 0.0.0  2020/9/3 15:00  zlj
 * 创建
 * -------------------------------------------------------------------------------------------
 * version: 0.0.1  {date}       {author}
 * <p>
 * ===========================================================================================
 */
@RestController
@RequestMapping
public class IotMetadataController {

    @Autowired
    private IotMetadataService iotMetadataService;

    @GetMapping("entities/org/{code}")
    public ResultData<PageList<IotEntity>> findEntitiesByOrgCode(@PathVariable String code, PagingRequest pagingRequest){
        PageList list = iotMetadataService.findEntitiesByOrgCode(code, pagingRequest.toPaging());
        return ResultBuilder.getInstance()
                .data(list)
                .success()
                .build();
    }
    @GetMapping("points/entity/{id}")
    public ResultData<PageList<IotPoint>> findPointsByEntityId(@PathVariable String id, PagingRequest pagingRequest){
        List<IotPoint> list = iotMetadataService.findPointsByEntityId(id);
        return ResultBuilder.getInstance()
                .data(list)
                .success()
                .build();
    }

}
