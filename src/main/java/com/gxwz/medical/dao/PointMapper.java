package com.gxwz.medical.dao;

import java.util.List;

import com.gxwz.medical.entity.Point;

/**
 * 农合经办点数据访问层
 * @author 吴俊杰
 *
 */
public interface PointMapper {
  
	//按主键删除
    int deleteByPrimaryKey(Integer id);

    //选择性插入
    int insert(Point record);

    //插入
    int insertSelective(Point record);

    //按主键查询
    Point selectByPrimaryKey(Integer id);

    //更新
    int updateByPrimaryKeySelective(Point record);

    //更新
    int updateByPrimaryKey(Point record);

    //获取列表
	List<Point> selectByKeyWord(Point point);
}