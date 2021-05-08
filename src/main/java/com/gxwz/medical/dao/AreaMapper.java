package com.gxwz.medical.dao;

import java.util.List;

import com.gxwz.medical.entity.Area;

/**
 *  行政区域数据库访问层
 * @author 吴俊杰
 *
 */
public interface AreaMapper {
 
	//删除
    int deleteByPrimaryKey(Integer id);

    //插入
    int insert(Area record);

     //插入
    int insertSelective(Area record);

    //查询
    Area selectByPrimaryKey(Integer id);

   //更新 
    int updateByPrimaryKeySelective(Area record);

    //更新 
    int updateByPrimaryKey(Area record);

    //获取列表
	List<Area> selectByKeyWord(Area area);
}