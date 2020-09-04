package com.motor.iot.metadata.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.iot.metadata.IotEntity;
import com.motor.iot.metadata.server.command.IotEntityCreate;
import com.motor.iot.metadata.server.command.IotEntityModify;
import com.motor.iot.metadata.server.command.IotEntitySearch;
import com.motor.iot.metadata.server.service.IotEntityManagementService;
import com.motor.message.http.servlet.HttpServletCommandBuilder;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("management/iot/entity")
public class IotEntityManagementController {

    IotEntityManagementService iotEntityService;

    @PostMapping
    public ResultData create(@RequestBody IotEntityCreate IotEntityCreate){
        Command<IotEntityCreate> cmd = HttpServletCommandBuilder.get()
                .data(IotEntityCreate)
                .build();
        iotEntityService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable String id){
        Command<String> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        iotEntityService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable String id, @RequestBody IotEntityModify IotEntityModify){
        IotEntityModify.setId(id);
        Command<IotEntityModify> cmd = HttpServletCommandBuilder.get()
                .data(IotEntityModify)
                .build();
        iotEntityService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable String id){
        Command<String> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        iotEntityService.findById(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<IotEntity>> search(@RequestBody IotEntitySearch IotEntitySearch){
        Command<IotEntitySearch> cmd = HttpServletCommandBuilder.get()
                .data(IotEntitySearch)
                .build();
        PageList<IotEntity> pageList = iotEntityService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
