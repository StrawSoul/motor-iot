package com.motor.iot.metadata.server.repository.mapper;

import com.motor.common.domain.SearchCondition;
import com.motor.common.paging.PageList;
import com.motor.common.paging.Paging;
import com.motor.common.paging.PagingRequest;
import com.motor.iot.metadata.IotModel;
import com.motor.iot.metadata.server.command.IotModelSearch;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
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
@Repository
public interface IotModelMapper {

    PageList<IotModel> selectWithPage(Map<String,Object> searchCondition, Paging paging);
    PageList<IotModel> selectWithPage(SearchCondition searchCondition, Paging paging);
}
