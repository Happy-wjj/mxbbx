package com.gxwz.medical.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxwz.medical.entity.Role;

/**
 * 角色数据访问层
 * @author 吴俊杰
 *
 */
public interface RoleMapper {

    //选择性插入
    int insertSelective(Role record);

    //按主键查询
    Role selectByPrimaryKey(Integer roleid);
    
    //按主键查询
    Role selectByPrimaryKeyCascade(Integer roleid);
    
    //获取列表
    List<Role> selectByKeyword(Role role);
    
    //级联模糊查询
    List<Role> selectByKeywordCascade(Role role);
    
    //判断是否有相同名称的角色
    List<Role> hasSameRole(@Param("roleid") Integer roleid, @Param("rolename") String rolename);

    //更新
    int updateByPrimaryKeySelective(Role record);
    
    //删除某个角色的全部权限信息（更新权限设置用）
    int deleteOldRoleRights(Integer roleid);
    
    //为某个角色设置权限
    int insertNewRoleRightInfo(@Param("roleid") Integer roleid, @Param("funid") Integer funid);

}