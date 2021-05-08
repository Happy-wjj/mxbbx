package com.gxwz.medical.service;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxwz.medical.dao.AreaMapper;
import com.gxwz.medical.dao.PointMapper;
import com.gxwz.medical.entity.Area;

/**
 * 行政区域管理业务逻辑
 * 
 * @author 吴俊杰
 *
 */
@Service
public class AreaService {

	@Autowired
	private PointMapper pointMapper;
	@Autowired
	private AreaMapper areaMapper;

	/**
	 * 创建SqlSession的工厂类
	 */
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	// 更新行政区域信息
	@Transactional
	public boolean updateArea(Area area) {
		System.out.println("updateByPrimaryKey(Point)" + areaMapper.updateByPrimaryKey(area));
		return areaMapper.updateByPrimaryKeySelective(area) > 0;

	}

	// 新增行政区域信息
	@Transactional
	public boolean addArea(Area area) {
		/* return PointMapper.insert(Point) > 0; */
		return areaMapper.insertSelective(area) > 0;
	}

	// 模糊查询
	public List<Area> findByKeyword(Area area) {
		return areaMapper.selectByKeyWord(area);
	}

	// 按行政区域主键ID查询
	public Area findbyId(Integer id) {

		return areaMapper.selectByPrimaryKey(id);
	}

	//按家庭档案信息主键ID删除
	@Transactional
	public int deleteArea(Integer fid) {
		return areaMapper.deleteByPrimaryKey(fid);
	}



}
