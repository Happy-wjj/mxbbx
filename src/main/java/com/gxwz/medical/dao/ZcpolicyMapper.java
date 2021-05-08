package com.gxwz.medical.dao;

import java.util.List;

import com.gxwz.medical.entity.Zcpolicy;

/**
 * 慢性病证数据访问层
 * @author 吴俊杰
 *
 */
public interface ZcpolicyMapper {
	
	//删除
    int deleteByPrimaryKey(Integer id);

    //选择性插入
    int insert(Zcpolicy record);

    //插入
    int insertSelective(Zcpolicy record);

    //按主键查询
    Zcpolicy selectByPrimaryKey(Integer id);

    //更新
    int updateByPrimaryKeySelective(Zcpolicy record);

    //更新
    int updateByPrimaryKey(Zcpolicy record);

    //获取列表
	List<Zcpolicy> selectByAll(Zcpolicy zcpolicy);

    //按主键查询
	public Zcpolicy findByYea(Integer timeint);
}