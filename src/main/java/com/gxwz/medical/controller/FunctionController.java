package com.gxwz.medical.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gxwz.medical.entity.Function;
import com.gxwz.medical.service.FunctionService;

/**
 * 功能Controller
 * @author 李圣�?
 *
 */
@Controller
@RequestMapping("/fun")
public class FunctionController {

	/**
	 * 功能业务逻辑
	 */
	@Autowired
	private FunctionService functionService;
	
	/**
	 * 分页+模糊查询
	 * @param pageNo 当前�?
	 * @param pageCount 每页记录�?
	 * @param keyword 功能名称
	 * @param function 待查参数
	 * @return
	 */
	@RequestMapping("/funs")
	public String findByKeyword(Map<String, Object> map,
			@RequestParam(value="pageNo", defaultValue="1", required=false) Integer pageNo,
			@RequestParam(value="pageCount", defaultValue="10", required=false) Integer pageCount,
			@RequestParam(value="keyword", required=false) String keyword) {
		
		// 引入PageHelper分页插件
		// 在查询之前只�?要调用，传入页码，以及每页的大小
		PageHelper.startPage(pageNo, pageCount);
		
		// 分页查询得到结果�?
		List<Function> functions;
		
		if (StringUtils.hasText(keyword)) {
			Function function = new Function();
			function.setFunname(keyword);
			functions = functionService.getFunctionList(function);
			System.out.println("getFunctionList(function)"+functionService.getFunctionList(function));
		} else {
			functions = functionService.getFunctionList(null);
		}
		
		
		// 使用pageInfo包装查询后的结果，只�?要将pageInfo交给页面就行了�??
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo<Function> page = new PageInfo<Function>(functions, 5);
		
		//保存结果集带到页面显�?
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		
		//保存模糊查询条件以便回显
		map.put("keyword", keyword);
		
		return "function/functionManage";

	}
	
	/**
	 * 跳到添加界面
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd(Map<String, Object> map) {
		
		//取出�?有的顶级功能和父功能,保存备�?�项供显�?
		map.put("functionList", functionService.getTopFunctions());
		
		return "function/functionadd";
	}
	
	/**
	 * 添加功能
	 * @return
	 */
	@RequestMapping("/addFunction")
	public String addFunction(Map<String, Object> map, @Valid Function function, BindingResult bindingResult) {
		
		//�?查校验是否出�?
		if(bindingResult.hasErrors()){
			List<ObjectError> list = bindingResult.getAllErrors();
			ObjectError oe = list.get(0);
			
			//校验失败信息
			map.put("result", false);
			map.put("msg", oe.getDefaultMessage() + "添加功能[" + function.getFunname() + "]失败�?");
		} else {
			//功能名称查重
			boolean hasSame = functionService.hasSameFunction(null, function.getFunname());
			
			if (hasSame == false) { //功能名称不重�?
				
				//保存功能信息，拿到添加操作的结果
				boolean result = functionService.addFunction(function);
				map.put("result", result);
				
				//根据操作结果生成提示信息
				if (result == true) {  //添加成功且无重复
					
					map.put("msg", "添加功能[" + function.getFunname() + "]成功");
				} else {
					
					map.put("msg", "添加功能[" + function.getFunname() + "]失败");
				}
				
			} else {
				map.put("result", false);
				map.put("msg", "功能名称[" + function.getFunname() + "]重复，添加功能失败！");
			}
		}

		return "forward:/fun/funs";
	}
	
	/**
	 * 跳到添加界面
	 * @return
	 */
	@RequestMapping("/toModify")
	public String toModify(Map<String, Object> map, Integer funid) {
		
		//取出�?有的顶级功能和父功能,保存备�?�项供显�?
		map.put("functionList", functionService.getTopFunctions());
		
		//取出待修改功能信�?
		map.put("function", functionService.getFunctionById(funid));
		
		return "function/functionmodify";
	}
	
	/**
	 * 修改功能
	 * @return
	 */
	@RequestMapping("/modifyFunction")
	public String modifyFunction(Map<String, Object> map, @Valid Function function, BindingResult bindingResult) {
		
		//�?查校验是否出�?
		if(bindingResult.hasErrors()){
			List<ObjectError> list = bindingResult.getAllErrors();
			ObjectError oe = list.get(0);
			
			//校验失败信息
			map.put("result", false);
			map.put("msg", oe.getDefaultMessage() + "修改功能[" + function.getFunname() + "]失败�?");
		} else {
			//功能名称查重
			boolean hasSame = functionService.hasSameFunction(function.getFunid(), function.getFunname());
			
			if (hasSame == false) { //功能名称不重�?
				
				//保存功能信息，拿到添加操作的结果
				boolean result = functionService.modifyFunction(function);
				map.put("result", result);
				
				//根据操作结果生成提示信息
				if (result == true) {  //添加成功且无重复
					
					map.put("msg", "修改功能[" + function.getFunname() + "]成功�?");
				} else {
					
					map.put("msg", "修改功能[" + function.getFunname() + "]失败�?");
				}
				
			} else {
				map.put("result", false);
				map.put("msg", "功能名称[" + function.getFunname() + "]重复，修改功能失败！");
			}
		}

		return "forward:/fun/funs";
	}
	
	/**
	 * 禁用
	 * @return
	 */
	@RequestMapping("/disable")
	public String disableFunction(Map<String, Object> map, Integer funid) {
		
		//保存功能信息，拿到删除操作的结果
		Function function = functionService.getFunctionById(funid);
		function.setFunstate(0);  //设为禁用
		boolean result = functionService.modifyFunction(function);
		map.put("result", result);
		
		//根据操作结果生成提示信息
		if (result == true) {  //添加成功且无重复
			
			map.put("msg", "禁用功能[" + function.getFunname() + "]成功�?");
		} else {
			
			map.put("msg", "禁用功能[" + function.getFunname() + "]失败�?");
		}
		
		return "forward:/fun/funs";
	}
	
	/**
	 * 启用
	 * @return
	 */
	@RequestMapping("/enable")
	public String enableFunction(Map<String, Object> map, Integer funid) {
		
		//保存功能信息，拿到删除操作的结果
		Function function = functionService.getFunctionById(funid);
		function.setFunstate(1);  //设为禁用
		boolean result = functionService.modifyFunction(function);
		map.put("result", result);
		
		//根据操作结果生成提示信息
		if (result == true) {  //添加成功且无重复
			
			map.put("msg", "启用功能[" + function.getFunname() + "]成功�?");
		} else {
			
			map.put("msg", "启用功能[" + function.getFunname() + "]失败�?");
		}
		
		return "forward:/fun/funs";
	}
	
}
