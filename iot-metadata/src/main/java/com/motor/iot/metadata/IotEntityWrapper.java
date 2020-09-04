package com.motor.iot.metadata;

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
 * version: 0.0.0  2020/9/1 09:00  zlj
 * 创建
 * -------------------------------------------------------------------------------------------
 * version: 0.0.1  {date}       {author}
 * <p>
 * ===========================================================================================
 */
public class IotEntityWrapper extends IotEntity{

    private List<IotPoint>  entityPoints;
    private List<IotPoint>  modelPoints;

    public List<IotPoint> getEntityPoints() {
        return entityPoints;
    }

    public void setEntityPoints(List<IotPoint> entityPoints) {
        this.entityPoints = entityPoints;
    }

    public List<IotPoint> getModelPoints() {
        return modelPoints;
    }

    public void setModelPoints(List<IotPoint> modelPoints) {
        this.modelPoints = modelPoints;
    }
}
