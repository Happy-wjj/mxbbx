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
import com.gxwz.medical.dao.PersinfoMapper;
import com.gxwz.medical.dao.PointMapper;
import com.gxwz.medical.dao.UserMapper;
import com.gxwz.medical.entity.Family;
import com.gxwz.medical.entity.Persinfo;
import com.gxwz.medical.entity.Role;
import com.gxwz.medical.entity.Point;
import com.gxwz.medical.util.ExcelTools;
import com.gxwz.medical.util.MD5Helper;

/**
 *  参合登记表业务逻辑
 * @author 
 *
 */
@Service
public class PersinfoService {


	@Autowired
	private FamilyMapper familyMapper;
	
	@Autowired
	private PersinfoMapper persinfoMapper;

	//创建SqlSession的工场
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
    //更新参合登记信息
	@Transactional
	public boolean updatePersinfo(Persinfo persinfo) {
		return persinfoMapper.updateByPrimaryKeySelective(persinfo)> 0;
		/*return pointMapper.updateByPrimaryKey(point) > 0;*/
		
	}
	
	 //新增参合登记信息
	@Transactional
	public boolean addPersinfo(Persinfo persinfo) {
		/*return PointMapper.insert(Point) > 0;*/
		return persinfoMapper.insertSelective(persinfo) > 0;
	}
	
	//模糊查询
	public List<Persinfo> findByKeyword(Persinfo persinfo) {
		return persinfoMapper.selectByKeyWord(persinfo);
	}
	
	//按参合登记主键ID查询
	public Persinfo findbyId(Integer id) {
		
		return persinfoMapper.selectByPrimaryKey(id);
	}

	//按persinfoMapper主键ID删除
	@Transactional
	public int deletePersinfo(Integer id) {
		return persinfoMapper.deleteByPrimaryKey(id);
	}

	public int deletePersinfofid(Integer familyid) {
		return persinfoMapper.deleteByfamilyid(familyid);
	}

	public Persinfo ValidateCardno(String keyword) {
		return persinfoMapper.ValidateCardno(keyword);
	}

}
