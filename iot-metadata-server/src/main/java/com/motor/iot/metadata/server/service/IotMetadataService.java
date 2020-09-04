package com.motor.iot.metadata.server.service;

import com.motor.common.dsl.bean.Condition;
import com.motor.common.paging.PageList;
import com.motor.common.paging.Paging;
import com.motor.common.spring.repository.SimpleRepository;
import com.motor.common.table.bean.Column;
import com.motor.common.utils.M;
import com.motor.iot.metadata.*;
import com.motor.iot.metadata.server.command.IotEntityPointConfig;
import com.motor.iot.metadata.server.command.IotModelPointConfig;
import com.motor.iot.metadata.pointid.IotPointId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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
@Service
public class IotMetadataService {

    @Autowired
    IotEntityRepository iotEntityRepository;
    @Autowired
    IotModelRepository iotModelRepository;

    @Autowired
    IotEntityPointRepository iotEntityPointRepository;

    @Autowired
    IotModelPointRepository iotModelPointRepository;

    @Autowired
    SimpleRepository<String, IotEntityPointConfig> iotEntityPointConfigRepository;

    @Autowired
    SimpleRepository<String, IotModelPointConfig> iotModelPointConfigRepository;

    public PageList findEntitiesByOrgCode(String code, Paging paging) {

        Condition condition = Condition.is(new Column("org_code"), code);

        PageList<IotEntity> pageList = iotEntityRepository.search(condition, paging);

        return pageList;
    }

    public List<IotPoint> findPointsByEntityId(String id) {

        id = Optional.of(id).get();

        IotEntity entity = iotEntityRepository.findById(id);

        Map<String,IotPoint> pool = new HashMap<>();

        loadPointsOfModel(pool, entity);

        loadPointsOfEntity(pool, entity);

        return new ArrayList<>(pool.values());
    }


    private void loadPointsOfEntity(Map<String,IotPoint> pool , IotEntity entity){
        Condition condition = Condition.is(new Column("entity_id"), entity.getId());
        List<IotEntityPoint> entityPoints = iotEntityPointRepository.select(condition);
        List<IotPoint> points = entityPoints.stream().map(e -> new IotPoint(new IotPointId(e, entity))).collect(Collectors.toList());
        List<String> entityPointCodes = points.stream().map(e -> e.getPointId().toString()).collect(Collectors.toList());
        for (IotPoint point : points) {
            pool.put(point.getPointId().toString(), point);
        }
        Condition epcCondi = Condition.exists(new Column("entity_point_code"), entityPointCodes);
        List<IotEntityPointConfig> epcList = iotEntityPointConfigRepository.select(epcCondi);
        for (IotEntityPointConfig epc : epcList) {
            IotPoint p = pool.get(epc.getEntityPointCode());
            p.setConfig(epc.getType(), epc.getConfigKey(), epc.getConfigValue());
        }
    }

    private void loadPointsOfModel(Map<String,IotPoint> pool , IotEntity entity){
        if (!M.isEmpty(entity.getModelId())) {
            Condition modelCondi = Condition.is(new Column("model_id"), entity.getModelId());
            IotModel model = iotModelRepository.findById(entity.getModelId());
            List<IotModelPoint> modelPoints = iotModelPointRepository.select(modelCondi);
            List<IotPoint> points = modelPoints.stream().map(e ->new IotPoint(new IotPointId(e, model, entity))).collect(Collectors.toList());
            List<String> modelPointCodes = points.stream().map(e -> e.getPointId().toModelPointCode()).collect(Collectors.toList());
            Condition mpcCondi = Condition.exists(new Column("model_point_code"), modelPointCodes);
            List<IotModelPointConfig> mpcConfigs = iotModelPointConfigRepository.select(mpcCondi);
            Map<String, IotModelPointConfig> mpcMap = mpcConfigs.stream().collect(Collectors.toMap(e -> e.getModelPointId(), f -> f));

            for (IotPoint point : points) {
                IotModelPointConfig mpc = mpcMap.get(point.getPointId().toString());
                point.setConfig(mpc.getType(), mpc.getConfigKey(), mpc.getConfigValue());
                pool.put(point.getPointId().toString(), point);
            }
        }
    }
}
