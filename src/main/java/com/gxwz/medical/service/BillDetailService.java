package com.gxwz.medical.service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxwz.medical.dao.RoleMapper;
import com.gxwz.medical.dao.BilldetailMapper;
import com.gxwz.medical.dao.FamilyMapper;
import com.gxwz.medical.dao.PointMapper;
import com.gxwz.medical.dao.UserMapper;
import com.gxwz.medical.entity.Billdetail;
import com.gxwz.medical.entity.Family;
import com.gxwz.medical.entity.Role;
import com.gxwz.medical.entity.Point;
import com.gxwz.medical.util.ExcelTools;
import com.gxwz.medical.util.MD5Helper;

/**
 * 农合经办点service
 * @author 李圣�?
 *
 */
@Service
public class BillDetailService {

	/**
	 * Mapper
	 */
	@Autowired
	private FamilyMapper familyMapper;
	
	@Autowired
	private BilldetailMapper billdetailMapper;
	/**
	 * 创建SqlSession的工�?
	 */
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	/**农合经办�?
	 * @param id
	 * @return
	 */
	@Transactional
	public boolean updateBilldetail(Billdetail billdetail) {
		return billdetailMapper.updateByPrimaryKeySelective(billdetail)> 0;
		/*return pointMapper.updateByPrimaryKey(point) > 0;*/
		
	}
	
	/**
	 * 逐个添加农合经办�?
	 * @param Point
	 * @return
	 */
	@Transactional
	public boolean addBilldetail(Billdetail billdetail) {
		/*return PointMapper.insert(Point) > 0;*/
		return billdetailMapper.insertSelective(billdetail) > 0;
	}
	
	/**
	 * 模糊查询
	 * @return
	 */
	public List<Billdetail> findByKeyword(Billdetail billdetail) {
		return billdetailMapper.selectByKeyWord(billdetail);
	}
	
	/**
	 * 按农合经办点id查询
	 * @param userid
	 * @return
	 */
	public Billdetail findbyId(Integer id) {
		
		return billdetailMapper.selectByPrimaryKey(id);
	}

	/**
	 * 按农合经办点id删除
	 * @param userid
	 * @return
	 */
	@Transactional
	public int deleteBilldetail(Integer id) {
		return billdetailMapper.deleteByPrimaryKey(id);
	}

	public Billdetail ValidateCardno(String cardno) {
		return billdetailMapper.ValidateCardno(cardno);
	}

	public int deleteBilldetailfid(Integer fid) {
		return billdetailMapper.deleteBilldetailfid(fid);
	}

}
