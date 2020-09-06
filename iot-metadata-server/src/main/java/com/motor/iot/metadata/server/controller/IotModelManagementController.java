package com.motor.iot.metadata.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.common.paging.PagingRequest;
import com.motor.iot.metadata.IotModel;
import com.motor.iot.metadata.server.command.IotModelCreate;
import com.motor.iot.metadata.server.command.IotModelModify;
import com.motor.iot.metadata.server.command.IotModelSearch;
import com.motor.iot.metadata.server.service.IotModelManagementService;
import com.motor.message.http.servlet.HttpServletCommandBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("management/iot/model")
public class IotModelManagementController {

    @Autowired
    IotModelManagementService iotModelService;

    @PostMapping
    public ResultData create(@RequestBody IotModelCreate iotModelCreate){
        Command<IotModelCreate> cmd = HttpServletCommandBuilder.get()
                .data(iotModelCreate)
                .build();
        iotModelService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable String id){
        Command<String> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        iotModelService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable String id, @RequestBody IotModelModify iotModelModify){
        iotModelModify.setId(id);
        Command<IotModelModify> cmd = HttpServletCommandBuilder.get()
                .data(iotModelModify)
                .build();
        iotModelService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable String id){
        Command<String> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        iotModelService.findById(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<IotModel>> search(@RequestBody IotModelSearch iotModelSearch){
        Command<IotModelSearch> cmd = HttpServletCommandBuilder.get()
                .data(iotModelSearch)
                .build();
        PageList<IotModel> pageList = iotModelService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
