package com.gxwz.medical.dao;

import java.util.List;

import com.gxwz.medical.entity.Billdetail;


/**
 * 慢性病报销信息数据访问层
 * @author 吴俊杰
 *
 */
public interface BilldetailMapper {
	
	//删除
    int deleteByPrimaryKey(Integer id);

    //选择性插入
    int insert(Billdetail record);

    //插入
    int insertSelective(Billdetail record);

    //按主键查询
    Billdetail selectByPrimaryKey(Integer id);

    //更新
    int updateByPrimaryKeySelective(Billdetail record);

    //更新
    int updateByPrimaryKey(Billdetail record);

    //获取列表
	List<Billdetail> selectByKeyWord(Billdetail billdetail);

	//按身份证查询
	public Billdetail ValidateCardno(String cardno);

	//按家庭档案主键查询
	public int deleteBilldetailfid(Integer fid);
}