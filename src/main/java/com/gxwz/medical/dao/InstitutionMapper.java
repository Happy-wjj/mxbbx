package com.gxwz.medical.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gxwz.medical.entity.Institution;

/**
 * 机构数据访问层
 * @author 吴俊杰
 *
 */
public interface InstitutionMapper {
	
    //选择性插入
    int insertSelective(Institution record);

    //按主键id查询
    Institution selectByPrimaryKey(Integer instid);
    
    //模糊查询
    List<Institution> selectByKeyWord(Institution institution);
    
    //按机构名称查询
    List<Institution> hasSameInstitution(@Param("instid") Integer instid, @Param("instname") String instname);
    
   //查询还没有参合的机构
    List<Institution> selectInstitutionNoUserUnder();
    
     //查询出下面有用户的机构（未被合并）
    List<Institution> selectInstitutionHasUserUnderAndValid();

    //动态更新
    int updateByPrimaryKeySelective(Institution record);
    
    //判断机构下面是否还有用户（机构合并的时候用）
    long isInstitutionHasUser(Integer instid);

}