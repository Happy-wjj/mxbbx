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
import com.gxwz.medical.dao.MbbillMapper;
import com.gxwz.medical.dao.PointMapper;
import com.gxwz.medical.dao.UserMapper;
import com.gxwz.medical.dao.ZcpolicyMapper;
import com.gxwz.medical.entity.Mbbill;
import com.gxwz.medical.entity.Role;
import com.gxwz.medical.entity.Zcpolicy;
import com.gxwz.medical.entity.Point;
import com.gxwz.medical.util.ExcelTools;
import com.gxwz.medical.util.MD5Helper;

/**
 * 慢性病证业务逻辑
 * @author 吴俊杰
 *
 */
@Service
public class MbbillService {

	@Autowired
	private MbbillMapper mbbillMapper;
	
	@Autowired
	private ZcpolicyMapper zcpolicyMapper;
	
	//创建SqlSession的工场
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	//更新慢性病信息
	@Transactional
	public boolean updateMbbill(Mbbill mbbill) {
		return mbbillMapper.updateByPrimaryKeySelective(mbbill)> 0;
		
	}
	
    //添加慢性病信息
	@Transactional
	public boolean addMbbill(Mbbill mbbill) {
		/*return PointMapper.insert(Point) > 0;*/
		return mbbillMapper.insertSelective(mbbill) > 0;
	}
	
	//慢性病模糊查询
	public List<Mbbill> findByKeyword(Mbbill mbbill) {
		return mbbillMapper.selectByAll(mbbill);
	}
	
   //按照慢性病主键id查询
	public Mbbill findbyId(Integer id) {
		
		return mbbillMapper.selectByPrimaryKey(id);
	}

	//按照慢性病主键id删除
	@Transactional
	public int deleteMbbill(Integer id) {
		return mbbillMapper.deleteByPrimaryKey(id);
	}

}
