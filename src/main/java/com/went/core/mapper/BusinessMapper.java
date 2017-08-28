package com.went.core.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * mybatis sql映射自定义接口
 *
 * @author wzp 2015年12月17日
 */
@Mapper
public interface BusinessMapper<T>{

    /**
     * 查询方法,返回记录 List 参数: entity <p> 2015年12月17日
     */
    List<T> select();

    /**
     * 插入方法 参数: entity <p> 2015年12月17日
     */
    int insert(T entity);


    /**
     * 更新方法 参数: entity <p> 2015年12月17日
     */
    int update(T entity);


    /**
     * 删除方法 参数: entity <p> 2015年12月17日
     */
    int delete(T entity);
}