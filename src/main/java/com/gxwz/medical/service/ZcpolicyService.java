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
import com.gxwz.medical.dao.ZcpolicyMapper;
import com.gxwz.medical.entity.Role;
import com.gxwz.medical.entity.Zcpolicy;
import com.gxwz.medical.entity.Point;
import com.gxwz.medical.util.ExcelTools;
import com.gxwz.medical.util.MD5Helper;

/**
 *    慢性病政策业务逻辑
 * 
 * @author 吴俊杰
 *
 */
@Service
public class ZcpolicyService {

	/**
	 * 农合经办点Mapper
	 */
	@Autowired
	private PointMapper pointMapper;

	/**
	 * 慢性病政策Mapper
	 */
	@Autowired
	private ZcpolicyMapper zcpolicyMapper;

	/**
	 * 创建SqlSession的工厂类
	 */
	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	/**
	 * 更新慢性病政策
	 */
	@Transactional
	public boolean updateZcpolicy(Zcpolicy zcpolicy) {
		return zcpolicyMapper.updateByPrimaryKeySelective(zcpolicy) > 0;

	}

	/**
	 * 逐个添加慢性病政策
	 * 
	 * @param Point
	 * @return
	 */
	@Transactional
	public boolean addZcpolicy(Zcpolicy zcpolicy) {
		/* return PointMapper.insert(Point) > 0; */
		return zcpolicyMapper.insertSelective(zcpolicy) > 0;
	}

	/**
	 * 模糊查询
	 * 
	 * @return
	 */
	public List<Zcpolicy> findByKeyword(Zcpolicy zcpolicy) {
		return zcpolicyMapper.selectByAll(zcpolicy);
	}

	/**
	 * 按慢性病政策id查询
	 * 
	 * @param userid
	 * @return
	 */
	public Zcpolicy findbyId(Integer id) {

		return zcpolicyMapper.selectByPrimaryKey(id);
	}

	/**
	 * 按慢性病政策id删除
	 * 
	 * @param userid
	 * @return
	 */
	@Transactional
	public int deleteZcpolicy(Integer id) {
		return zcpolicyMapper.deleteByPrimaryKey(id);
	}

	public Zcpolicy findByYear(Integer timeint) {
		return zcpolicyMapper.findByYea(timeint);
	}

}
