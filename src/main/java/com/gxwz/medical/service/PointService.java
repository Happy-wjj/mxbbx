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
import com.gxwz.medical.dao.PointMapper;
import com.gxwz.medical.dao.UserMapper;
import com.gxwz.medical.entity.Role;
import com.gxwz.medical.entity.Point;
import com.gxwz.medical.util.ExcelTools;
import com.gxwz.medical.util.MD5Helper;

/**
 * 农合经办点业务逻辑
 * @author 
 *
 */
@Service
public class PointService {

	@Autowired
	private PointMapper pointMapper;
	
    //创建SqlSession的工场
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	//更新农合经办点信息
	@Transactional
	public boolean updatePoint(Point point) {
		System.out.println("pointMapper.updateByPrimaryKeySelective(point)"+pointMapper.updateByPrimaryKeySelective(point));
		System.out.println("updateByPrimaryKey(Point)"+pointMapper.updateByPrimaryKey(point));
		return pointMapper.updateByPrimaryKeySelective(point)> 0;
		/*return pointMapper.updateByPrimaryKey(point) > 0;*/
		
	}
	
	//新增农合经办点信息
	@Transactional
	public boolean addPoint(Point point) {
		/*return PointMapper.insert(Point) > 0;*/
		return pointMapper.insertSelective(point) > 0;
	}
	
	//模糊查询
	public List<Point> findByKeyword(Point point) {
		return pointMapper.selectByKeyWord(point);
	}
	
	//按农合经办点主键ID查询
	public Point findbyId(Integer id) {
		
		return pointMapper.selectByPrimaryKey(id);
	}

	//按农合经办点主键ID删除
	@Transactional
	public int deletePoint(Integer id) {
		return pointMapper.deleteByPrimaryKey(id);
	}

}
