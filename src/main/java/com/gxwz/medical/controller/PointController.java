package com.gxwz.medical.controller;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gxwz.medical.entity.Role;
import com.gxwz.medical.entity.Point;
import com.gxwz.medical.service.RoleService;
import com.gxwz.medical.service.PointService;
import com.gxwz.medical.service.UserService;
import com.gxwz.medical.util.MD5Helper;
import com.gxwz.medical.validategroup.UserValidateGroupForInsert;
import com.gxwz.medical.validategroup.UserValidateGroupForPasswordModify;
import com.gxwz.medical.validategroup.UserValidateGroupForUpdate;
import com.gxwz.medical.validategroup.UserValidateGroupForUserModify;

/**
 * 农合经办点管理Controller
 * @author 吴俊杰
 *
 */
@Controller
@RequestMapping("/point")
public class PointController {
	
	@Autowired
	private PointService pointService;
	
	//进入修改农合经办点信息界面
	@RequestMapping("/toEdit")
	public String toEdit(Map<String, Object> map,Integer id) {
		//根据id查找
		Point point = pointService.findbyId(id);
		map.put("point", point);
		return "Point/PointEdit";
	}	
	
	//修改农合经办点信息操作
	@RequestMapping("/edit")
	public String edit(Map<String, Object> map,
			//指定由哪个校验组校验
			Point point,BindingResult bindingResult,Integer id) {
				//获取id值
				id = point.getId();
				System.out.println("id"+id);
				//保存农合经办点的信息
				boolean result = pointService.updatePoint(point);
				System.out.println("point"+point);
				map.put("result", result);
				return "forward:/point/list";
	}
	

   //进入新增农合经办点信息界面
	@RequestMapping("/toAdd")
	public String toAdd(Map<String, Object> map) {
		
		return "Point/PointAdd";
	}
	
	//新增农合经办点信息操作
	@RequestMapping("/add")
	public String add(Map<String, Object> map, 
			@Validated(value = UserValidateGroupForInsert.class) Point point,
			BindingResult bindingResult) {
				//保存农合经办点的信息，拿到添加操作的结果
				boolean result = pointService.addPoint(point);
				map.put("result", result);

		return "forward:/point/list";
	}
	
	//删除农合经办点信息操作
	@RequestMapping("/delete")
	public String delete(Map<String, Object> map, 
			//指定由固定的校验组校�?
			@Validated(value = UserValidateGroupForInsert.class) Point point,Integer id,
			BindingResult bindingResult) {
				
				//保存用户信息，拿到添加操作的结果
				int result = pointService.deletePoint(id);
				map.put("result", result);
			
		return "forward:/point/list";
	}
	
   //查看农合经办点信息
	@RequestMapping("/list")
	public String list(Map<String, Object> map,
			@RequestParam(value="pageNo", defaultValue="1", required=false) Integer pageNo,
			@RequestParam(value="pageCount", defaultValue="10", required=false) Integer pageCount,
			@RequestParam(value="pointno", required=false) String pointno) {
		
		// 引入PageHelper分页插件，在查询的时候调用，传入页码，以及每页的大小
		PageHelper.startPage(pageNo, pageCount);
		
		// 分页查询得到结果
		List<Point> points;
		
		if (pointno!= null) {
			Point point = new Point();
			point.setPointno(pointno);
			points = pointService.findByKeyword(point);
		} else {
			points = pointService.findByKeyword(null);
		}
		
		PageInfo<Point> page = new PageInfo<Point>(points, 5);
		
		//保存结果集
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		//保存模糊查询条件以便回显
		map.put("pointno", pointno);
		
		return "Point/PointList";
	}

}
