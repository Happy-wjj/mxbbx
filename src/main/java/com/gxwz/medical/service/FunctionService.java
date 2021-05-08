package com.gxwz.medical.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.gxwz.medical.dao.FunctionMapper;
import com.gxwz.medical.entity.Function;

/**
 *  菜单业务逻辑
 * @author 吴俊杰
 *
 */
@Service
public class FunctionService {
	

	@Autowired
	private FunctionMapper functionMapper;
	
    //获取全部菜单列表
	public List<Function> getFunctionList(Function function) {
		
		return functionMapper.selectByKeyWord(function);
	}
	
	//按菜单主键查询
	public Function getFunctionById(Integer funid) {
		
		return functionMapper.selectByPrimaryKey(funid);
	}
	

	public List<Function> getTopFunctions() {
		
		Function function = new Function();
		function.setFunpid(-1); //要求父功能为根节点�?�父功能”，加载出所有顶层功�?
		
		return functionMapper.selectByKeyWord(function);
	}
	
    //判断是否有相同的菜单名称
	public boolean hasSameFunction(Integer funid, String funname) {
		
		//按菜单名称模糊查询
		Function function = new Function();
		function.setFunname(funname);
		if (funid != null) {
			function.setFunid(funid);
		}
		List<Function> functions = functionMapper.selectByFunname(function);
	
		if (functions.size() > 0) {
			return true;
		}

		return false;
	}
	
    //新增菜单
	@Transactional
	public boolean addFunction(Function function) {
		
		return functionMapper.insertSelective(function) > 0;
	}
	
	//更新菜单 
	@Transactional
	public boolean modifyFunction(Function function) {
		
		return functionMapper.updateByPrimaryKeySelective(function) > 0;
	}

}
