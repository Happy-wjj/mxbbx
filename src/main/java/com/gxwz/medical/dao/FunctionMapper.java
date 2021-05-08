package com.gxwz.medical.dao;

import java.util.List;

import com.gxwz.medical.entity.Function;

/**
 * 菜单数据访问层
 * @author 吴俊杰
 *
 */
public interface FunctionMapper {
    
    //选择性插入
    int insertSelective(Function record);

   //按主键查询
    Function selectByPrimaryKey(Integer funid);
    
   //模糊查询
    List<Function> selectByKeyWord(Function function);
    
    //按菜单名称查询
    List<Function> selectByFunname(Function function);

    // 选择性按主键更新，不更新的字段设空
    int updateByPrimaryKeySelective(Function record);

}