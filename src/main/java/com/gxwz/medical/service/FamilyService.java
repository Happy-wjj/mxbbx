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
import com.gxwz.medical.dao.FamilyMapper;
import com.gxwz.medical.dao.PointMapper;
import com.gxwz.medical.dao.UserMapper;
import com.gxwz.medical.entity.Family;
import com.gxwz.medical.entity.Role;
import com.gxwz.medical.entity.Point;
import com.gxwz.medical.util.ExcelTools;
import com.gxwz.medical.util.MD5Helper;

/**
 * 家庭档案信息service
 * @author 
 *
 */
@Service
public class FamilyService {


	@Autowired
	private FamilyMapper familyMapper;
	
	/**
	 * 创建SqlSession的工场
	 */
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	//更新家庭档案信息
	@Transactional
	public boolean updateFamily(Family family) {
		return familyMapper.updateByPrimaryKeySelective(family)> 0;
		/*return pointMapper.updateByPrimaryKey(point) > 0;*/
		
	}
	
    //新增家庭档案信息
	@Transactional
	public boolean addFamily(Family family) {
		/*return PointMapper.insert(Point) > 0;*/
		return familyMapper.insertSelective(family) > 0;
	}
	
	//模糊查询
	public List<Family> findByKeyword(Family family) {
		return familyMapper.selectByKeyWord(family);
	}
	
	//按家庭档案信息主键ID查询
	public Family findbyId(Integer fid) {
		
		return familyMapper.selectByPrimaryKey(fid);
	}

	//按家庭档案信息主键ID删除
	@Transactional
	public int deleteFamily(Integer fid) {
		return familyMapper.deleteByPrimaryKey(fid);
	}

}
