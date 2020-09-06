package com.motor.iot.metadata.pointid;

import com.motor.iot.metadata.*;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

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
 * version: 0.0.0  2020/9/3 16:00  zlj
 * 创建
 * -------------------------------------------------------------------------------------------
 * version: 0.0.1  {date}       {author}
 * <p>
 * ===========================================================================================
 */
public class IotPointId implements Serializable {

    private static final long serialVersionUID = -1519855236614634243L;

    private String version;
    private IotSpace space;
    private IotModelCode modelCode;
    private IotPointCode pointCode;
    private String entityCode;

    public IotPointId(IotEntityPoint entityPoint, IotEntity entity) {
        this.space = new IotSpace(entity.getNamespace());
        this.modelCode = new IotModelCode(entity.getCategoryId(), "0");
        this.pointCode = new IotPointCode("2", entityPoint.getDataType(), entityPoint.getCode());
        this.entityCode = entity.getCode();
    }
    public IotPointId(IotModelPoint entityPoint, IotModel model, IotEntity entity) {
        this.space = new IotSpace(entity.getNamespace());
        this.modelCode = new IotModelCode(entity.getCategoryId(), model.getCode());
        this.pointCode = new IotPointCode("1", entityPoint.getDataType(), entityPoint.getCode());
        this.entityCode = entity.getCode();
    }


    public IotPointId(IotSpace space, IotModelCode modelCode, IotPointCode pointCode, String entityCode) {
        this.space = space;
        this.modelCode = modelCode;
        this.pointCode = pointCode;
        this.entityCode = entityCode;
    }

    public IotPointId(String version, IotSpace space, IotModelCode modelCode, IotPointCode pointCode, String entityCode) {
        this.version = version;
        this.space = space;
        this.modelCode = modelCode;
        this.pointCode = pointCode;
        this.entityCode = entityCode;
    }

    public IotPointId() {
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public IotSpace getSpace() {
        return space;
    }

    public void setSpace(IotSpace space) {
        this.space = space;
    }

    public IotModelCode getModelCode() {
        return modelCode;
    }

    public void setModelCode(IotModelCode modelCode) {
        this.modelCode = modelCode;
    }

    public IotPointCode getPointCode() {
        return pointCode;
    }

    public void setPointCode(IotPointCode pointCode) {
        this.pointCode = pointCode;
    }

    public String getEntityCode() {
        return entityCode;
    }

    public void setEntityCode(String entityCode) {
        this.entityCode = entityCode;
    }

    public String toModelPointCode(){
        return new StringBuffer(modelCode.toString()).append("-").append(pointCode.toString()).toString();
    }

    @Override
    public String toString() {
        return (StringUtils.isNotEmpty(version)? new StringBuffer(version).append("-"): new StringBuffer())
                .append(modelCode.toString()).append("-")
                .append(pointCode.toString()).append("-")
                .append(entityCode)
                .toString();
    }
}
