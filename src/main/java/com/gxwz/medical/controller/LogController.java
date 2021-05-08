package com.gxwz.medical.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gxwz.medical.entity.Log;
import com.gxwz.medical.service.LogService;

/**
 * 日志Controller
 * @author 李圣�?
 *
 */
@Controller
@RequestMapping("/log")
public class LogController {

	/**
	 * 日志Service
	 */
	@Autowired
	private LogService logService;
	
	/**
	 * 分页+模糊查询
	 * @param pageNo 当前�?
	 * @param pageCount 每页记录�?
	 * @param function 待查参数
	 * @return
	 */
	@RequestMapping("/logs")
	public String logs(Map<String, Object> map,
			@RequestParam(value="pageNo", defaultValue="1", required=false) Integer pageNo,
			@RequestParam(value="pageCount", defaultValue="10", required=false) Integer pageCount,
			@RequestParam(value="keyword", required=false) String keyword) {
		
		// 引入PageHelper分页插件
		// 在查询之前只�?要调用，传入页码，以及每页的大小
		PageHelper.startPage(pageNo, pageCount);
		
		// 分页查询得到结果�?
		List<Log> logs;
		
		if (StringUtils.hasText(keyword)) {
			Log log = new Log();
			log.setOptname(keyword);
			logs = logService.findByKeyword(log);
		} else {
			logs = logService.findByKeyword(null);
		}
		
		// 使用pageInfo包装查询后的结果，只�?要将pageInfo交给页面就行了�??
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo<Log> page = new PageInfo<Log>(logs, 5);
		
		//保存结果集带到页面显�?
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		
		//保存模糊查询条件以便回显
		map.put("keyword", keyword);
		
		return "log/logManage";

	}
	
}
