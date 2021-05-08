package com.gxwz.medical.dao;

import java.util.List;

import com.gxwz.medical.entity.Log;

/**
 * 日志数据访问层
 * @author 吴俊杰
 *
 */
public interface LogMapper {

    //选择性插入
    int insertSelective(Log record);

    //模糊查询
    List<Log> selectByKeyword(Log log);
}