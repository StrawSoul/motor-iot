package com.motor.iot.metadata.server.controller;

import com.motor.common.message.command.Command;
import com.motor.common.message.result.ResultBuilder;
import com.motor.common.message.result.ResultData;
import com.motor.common.paging.PageList;
import com.motor.iot.metadata.IotEntityPoint;
import com.motor.iot.metadata.server.command.IotEntityPointCreate;
import com.motor.iot.metadata.server.command.IotEntityPointModify;
import com.motor.iot.metadata.server.command.IotEntityPointSearch;
import com.motor.iot.metadata.server.service.IotEntityPointManagementService;
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
@RequestMapping("management/iot/entity-point")
public class IotEntityPointManagementController {

    IotEntityPointManagementService iotEntityPointService;

    @PostMapping
    public ResultData create(@RequestBody IotEntityPointCreate IotEntityPointCreate){
        Command<IotEntityPointCreate> cmd = HttpServletCommandBuilder.get()
                .data(IotEntityPointCreate)
                .build();
        iotEntityPointService.create(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @DeleteMapping("{id}")
    public ResultData remove(@PathVariable String id){
        Command<String> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        iotEntityPointService.remove(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @PutMapping("{id}")
    public ResultData modify(@PathVariable String id, @RequestBody IotEntityPointModify IotEntityPointModify){
        IotEntityPointModify.setId(id);
        Command<IotEntityPointModify> cmd = HttpServletCommandBuilder.get()
                .data(IotEntityPointModify)
                .build();
        iotEntityPointService.modify(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping("{id}")
    public ResultData findById(@PathVariable String id){
        Command<String> cmd = HttpServletCommandBuilder.get()
                .data(id)
                .build();
        iotEntityPointService.findById(cmd);
        return ResultBuilder.getInstance()
                .success()
                .build();
    }
    @GetMapping
    public ResultData<PageList<IotEntityPoint>> search(@RequestBody IotEntityPointSearch IotEntityPointSearch){
        Command<IotEntityPointSearch> cmd = HttpServletCommandBuilder.get()
                .data(IotEntityPointSearch)
                .build();
        PageList<IotEntityPoint> pageList = iotEntityPointService.search(cmd);
        return ResultBuilder.getInstance()
                .data(pageList)
                .success()
                .build();
    }

}
