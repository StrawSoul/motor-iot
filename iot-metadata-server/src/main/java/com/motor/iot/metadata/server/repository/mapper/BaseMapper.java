package com.motor.iot.metadata.server.repository.mapper;

import com.motor.common.domain.Entity;
import com.motor.common.domain.SearchCondition;
import com.motor.common.paging.PageList;
import com.motor.common.paging.Paging;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
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
 * version: 0.0.0  2020/9/3 09:00  zlj
 * 创建
 * -------------------------------------------------------------------------------------------
 * version: 0.0.1  {date}       {author}
 * <p>
 * ===========================================================================================
 */
public interface BaseMapper<T, E extends Entity<T>>  {

    void insert(E entity);

    void insertBatch(Collection<E> var1);

    void delete(T id);

    int delete(SearchCondition var1);

    void remove(T var1);

    int remove(SearchCondition var1);

    int deleteAll();

    int removeAll();

    void update(E var1);

    void update(Map<String,Object> map);

    E findOne(SearchCondition var1);

    E findById(String var1);

    List<E> findByIds(Collection<T> var1);

    List<E> findByIds(T... var1);

    List<E> select(SearchCondition searchCondition);

    PageList<E> selectWithPage(@Param("params") SearchCondition searchCondition, @Param("paging") Paging paging);

    PageList<E> selectWithPage(@Param("params") Map<String,Object> searchCondition, @Param("paging") Paging paging);

}
