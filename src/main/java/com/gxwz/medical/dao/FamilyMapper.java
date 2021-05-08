package com.gxwz.medical.dao;

import java.util.List;

import com.gxwz.medical.entity.Family;


/**
 * 家庭档案信息数据访问层
 * @author 吴俊杰
 *
 */
public interface FamilyMapper {

	//删除
	int deleteByPrimaryKey(Integer fid);

    //选择性插入
    int insert(Family record);

    //插入
    int insertSelective(Family record);


    Family selectByPrimaryKey(Integer fid);

   //更新
    int updateByPrimaryKeySelective(Family record);

    //更新
    int updateByPrimaryKey(Family record);

    //获取列表
	List<Family> selectByKeyWord(Family family);
}