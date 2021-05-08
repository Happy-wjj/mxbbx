package com.gxwz.medical.dao;

import java.util.List;

import com.gxwz.medical.entity.Persinfo;

/**
 * 参合登记数据访问层
 * @author 吴俊杰
 *
 */
public interface PersinfoMapper {
  
	//删除
    int deleteByPrimaryKey(Integer id);

	//删除
    int deleteByfamilyid(Integer familyid);
 
    //选择性插入
    int insert(Persinfo record);

    //插入
    int insertSelective(Persinfo record);

    //按主键查询
    Persinfo selectByPrimaryKey(Integer id);

    //更新
    int updateByPrimaryKeySelective(Persinfo record);

    //更新
    int updateByPrimaryKey(Persinfo record);

    //获取列表
	List<Persinfo> selectByKeyWord(Persinfo persinfo);

	//模糊查询
	public Persinfo ValidateCardno(String keyword);
}