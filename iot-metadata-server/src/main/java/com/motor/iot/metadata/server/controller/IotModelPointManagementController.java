package com.motor.iot.metadata.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.iot.metadata.IotModelPoint;
import com.motor.iot.metadata.server.command.IotModelPointCreate;
import com.motor.iot.metadata.server.command.IotModelPointModify;
import com.motor.iot.metadata.server.command.IotModelPointSearch;
import com.motor.iot.metadata.server.service.IotModelPointManagementService;
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
@RequestMapping("management/iot/model-point")
public class IotModelPointManagementController {

    IotModelPointManagementService iotModelPointService;

    @PostMapping
    public ResultData create(@RequestBody IotModelPointCreate IotModelPointCreate){
        Command<IotModelPointCreate> cmd = HttpServletCommandBuilder.get()
                .data(IotModelPointCreate)
                .build();
        iotModelPointService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable String id){
        Command<String> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        iotModelPointService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable String id, @RequestBody IotModelPointModify IotModelPointModify){
        IotModelPointModify.setId(id);
        Command<IotModelPointModify> cmd = HttpServletCommandBuilder.get()
                .data(IotModelPointModify)
                .build();
        iotModelPointService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable String id){
        Command<String> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        iotModelPointService.findById(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<IotModelPoint>> search(@RequestBody IotModelPointSearch IotModelPointSearch){
        Command<IotModelPointSearch> cmd = HttpServletCommandBuilder.get()
                .data(IotModelPointSearch)
                .build();
        PageList<IotModelPoint> pageList = iotModelPointService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
