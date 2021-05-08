package com.gxwz.medical.dao;

import java.util.List;

import com.gxwz.medical.entity.Mbbill;


/**
 * 慢性病证数据访问层
 * @author 吴俊杰
 *
 */
public interface MbbillMapper {
	
	//删除
    int deleteByPrimaryKey(Integer id);

    //选择性插入
    int insert(Mbbill record);

    //插入
    int insertSelective(Mbbill record);

    //按主键查询
    Mbbill selectByPrimaryKey(Integer id);

    //更新
    int updateByPrimaryKeySelective(Mbbill record);

    //更新
    int updateByPrimaryKey(Mbbill record);

    //获取列表
	List<Mbbill> selectByAll(Mbbill mbbill);
}