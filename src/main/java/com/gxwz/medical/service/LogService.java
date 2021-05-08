package com.gxwz.medical.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gxwz.medical.dao.LogMapper;
import com.gxwz.medical.entity.Log;

/**
 * 日志业务逻辑
 * @author 吴俊杰
 *
 */
@Service
public class LogService {

	/**
	 * 日志Mapper
	 */
	@Autowired
	private LogMapper logMapper;
	
	/**
	 * 模糊查询
	 * @param log
	 * @return
	 */
	public List<Log> findByKeyword(Log log) {
		
		return logMapper.selectByKeyword(log);
	}
	
   //添加日志
	@Transactional
	public boolean addLog(Log log) {
		log.setOpttime(new Date());
		return logMapper.insertSelective(log) > 0;
	}
}
