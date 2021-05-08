package com.gxwz.medical.controller;

import java.io.InputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.gxwz.medical.entity.Family;
import com.gxwz.medical.entity.Persinfo;
import com.gxwz.medical.entity.Role;
import com.gxwz.medical.entity.User;
import com.gxwz.medical.entity.Zcpolicy;
import com.gxwz.medical.service.FamilyService;
import com.gxwz.medical.service.PersinfoService;
import com.gxwz.medical.service.RoleService;
import com.gxwz.medical.service.UserService;
import com.gxwz.medical.service.ZcpolicyService;
import com.gxwz.medical.util.MD5Helper;
import com.gxwz.medical.validategroup.UserValidateGroupForInsert;
import com.gxwz.medical.validategroup.UserValidateGroupForPasswordModify;
import com.gxwz.medical.validategroup.UserValidateGroupForUpdate;
import com.gxwz.medical.validategroup.UserValidateGroupForUserModify;

/**
 * 参合登记表Controller
 * @author 吴俊杰
 *
 */
@Controller
@RequestMapping("/persinfo")
public class PersinfoController {
	/**
	 * PersinfoService
	 */
	@Autowired
	private FamilyService familyService;

	@Autowired
	private PersinfoService persinfoService;
	
	@Autowired
	private ZcpolicyService zcpolicyService;

	//进入修改参合登记表界面
	@RequestMapping("/toEdit")
	public String toEdit(Map<String, Object> map,Integer id) {		
		//根据id查找
		Persinfo persinfo = persinfoService.findbyId(id);
		map.put("persinfo", persinfo);
		return "Persinfo/PersinfoEdit";
	}		
	
	//修改参合登记表操作
	@RequestMapping("/edit")
	public String edit(Map<String, Object> map,		
			Persinfo persinfo,BindingResult bindingResult,Integer id) {
				//获取id
				id = persinfo.getId();
				System.out.println("id"+id);
				//保存参合登记信息，拿到修改操作的结果
				boolean result = persinfoService.updatePersinfo(persinfo);
				map.put("result", result);
				return "forward:/persinfo/list";
	}
	

    //进入新增参合登记表界面
	@RequestMapping("/toAdd")
	public String toAdd(Map<String, Object> map) {
		
		return "Persinfo/PersinfoAdd";
	}
	
	//新增参合登记表操作
	@RequestMapping("/add")
	public String add(Map<String, Object> map, 
			//指定由固定的校验组校
			@Validated(value = UserValidateGroupForInsert.class) Persinfo persinfo,Family family,
			BindingResult bindingResult) {
				
				//保存参合登记信息，拿到添加操作的结果
				Date date=new Date();   //获取当前系统时间
				DateFormat format=new SimpleDateFormat("yyyy");
				/*DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
		   		String time = format.format(date); 	
				boolean result = persinfoService.addPersinfo(persinfo);
				map.put("result", result);
				
		return "forward:/persinfo/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Map<String, Object> map, 
			//指定由固定的校验组校�?
			@Validated(value = UserValidateGroupForInsert.class) Persinfo persinfo,Integer id,
			BindingResult bindingResult) {
				
				//保存用户信息，拿到添加操作的结果
				int result = persinfoService.deletePersinfo(id);
				map.put("result", result);
			
		return "forward:/persinfo/list";
	}
	
   //查看参合登记信息列表
	@RequestMapping("/list")
	public String list(Map<String, Object> map,
			@RequestParam(value="pageNo", defaultValue="1", required=false) Integer pageNo,
			@RequestParam(value="pageCount", defaultValue="10", required=false) Integer pageCount,
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="groupno", required=false) String groupno) {
		
		// 引入PageHelper分页插件，在查询的时候调用，传入页码，以及每页的大小	
		PageHelper.startPage(pageNo, pageCount);
		
		// 分页查询得到结果
		List<Persinfo> persinfos;
		
		if (keyword!= null) {
			Persinfo persinfo = new Persinfo();
			persinfo.setPersname(keyword);
			persinfos = persinfoService.findByKeyword(persinfo);
		} else {
			persinfos = persinfoService.findByKeyword(null);
		}
			
		PageInfo<Persinfo> page = new PageInfo<Persinfo>(persinfos, 5);
		
		//保存结果集
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		//保存模糊查询条件以便回显
		map.put("keyword", keyword);
		map.put("groupno", groupno);
		return "Persinfo/PersinfoList";
	}
	
    //通过户主姓名查询
	@RequestMapping("/input")
	public String input(Map<String, Object> map) {
		
		return "page/PerInputName";
	}

	
	@RequestMapping("/perfamily")
	public String list(Map<String, Object> map,
			@RequestParam(value="pageNo", defaultValue="1", required=false) Integer pageNo,
			@RequestParam(value="pageCount", defaultValue="10", required=false) Integer pageCount,
			@RequestParam(value="keyword", required=false) String keyword) {
		
		// 引入PageHelper分页插件，在查询的时候调用，传入页码，以及每页的大小	
		PageHelper.startPage(pageNo, pageCount);
		
		// 分页查询得到结果
		List<Family> familys;
		
		if (keyword!= null) {
			Family family = new Family();
			family.setMastername(keyword);
			familys = familyService.findByKeyword(family);
		} else {
			familys = familyService.findByKeyword(null);
		}
		
		PageInfo<Family> page = new PageInfo<Family>(familys, 5);
		
		//保存结果集
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		//保存模糊查询条件以便回显
		map.put("keyword", keyword);
		
		
		return "page/PerFamilyList";
	}


}
