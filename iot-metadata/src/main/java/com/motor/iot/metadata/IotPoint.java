package com.motor.iot.metadata;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.motor.iot.metadata.pointid.IotPointId;

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
 * version: 0.0.0  2020/9/1 09:00  zlj
 * 创建
 * -------------------------------------------------------------------------------------------
 * version: 0.0.1  {date}       {author}
 * <p>
 * ===========================================================================================
 */
public class IotPoint {

    private IotPointId pointId;
    private Map<String,Map<String,Map<String,Object>>> configs;

    public IotPoint() {
    }

    public IotPoint(IotPointId pointId) {
        this.pointId = pointId;
    }

    public IotPoint(IotPointId pointId, Map<String, Map<String, Map<String, Object>>> configs) {
        this.pointId = pointId;
        this.configs = configs;
    }

    public IotPointId getPointId() {
        return pointId;
    }

    public void setPointId(IotPointId pointId) {
        this.pointId = pointId;
    }

    public Map<String, Map<String, Map<String, Object>>> getConfigs() {
        return configs;
    }

    public void setConfigs(Map<String, Map<String, Map<String, Object>>> configs) {
        this.configs = configs;
    }

    public void setConfig(String type, String configKey, String configValue) {
        if(configs == null){
            configs = new HashMap<String, Map<String, Map<String, Object>>>();
        }
        Map<String, Map<String, Object>> typeConfig = configs.get(type);
        if(typeConfig == null){
            typeConfig = new HashMap<String, Map<String, Object>>();
            configs.put(type, typeConfig);
        }
        ObjectMapper om = new ObjectMapper();
        try {
            Map map = om.readValue(configValue, Map.class);
            typeConfig.put(configKey, map);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("point config json  wrong. pointId: "+ this.toString()+ " configKey: "+ type+"."+ configKey, e);
        }
    }
}
