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

import com.gxwz.medical.entity.Mbbill;
import com.gxwz.medical.entity.Role;
import com.gxwz.medical.entity.Point;
import com.gxwz.medical.service.MbbillService;
import com.gxwz.medical.service.RoleService;
import com.gxwz.medical.service.PointService;
import com.gxwz.medical.service.UserService;
import com.gxwz.medical.util.MD5Helper;
import com.gxwz.medical.validategroup.UserValidateGroupForInsert;
import com.gxwz.medical.validategroup.UserValidateGroupForPasswordModify;
import com.gxwz.medical.validategroup.UserValidateGroupForUpdate;
import com.gxwz.medical.validategroup.UserValidateGroupForUserModify;

/**
 * 慢性病证管理Controller
 * @author 吴俊杰
 *
 */
@Controller
@RequestMapping("/Mbbill")
public class MbbillController {
	
	@Autowired
	private MbbillService mbbillService;

    //新增慢性病信息
	@RequestMapping("/toAdd")
	public String toAdd(Map<String, Object> map) {
		
		return "forward:/Mbbill/list";
	}
	/**
	 * 进入修改信息的界面
	 * @param map
	 * @param userid
	 * @return
	 */
	@RequestMapping("/toEdit")
	public String toEdit(Map<String, Object> map,Integer id) {
		/*loadUserInfo(map, id);*/
		//根据id查找�?条记�?
		Mbbill mbbill = mbbillService.findbyId(id);
		map.put("mbbill", mbbill);
		return "forward:/Mbbill/list";
	}	
	
	
	/**
	 * 修改
	 * @param map
	 * @param point
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Map<String, Object> map,
			//指定由哪个校验组校验
			/*@Validated(value=UserValidateGroupForUpdate.class) */
			Mbbill mbbill,BindingResult bindingResult,Integer id) {
				//获取id的�??
				id = mbbill.getId();
				System.out.println("id"+id);
				//保存学生信息，拿到修改操作的结果
				boolean result = mbbillService.updateMbbill(mbbill);
				map.put("result", result);
				return "forward:/Mbbill/list";
	}
	
	
	@RequestMapping("/add")
	public String add(Map<String, Object> map, 
			//指定由固定的校验组校�?
			@Validated(value = UserValidateGroupForInsert.class) Mbbill mbbill,
			BindingResult bindingResult) {
				//保存用户信息，拿到添加操作的结果
				boolean result = mbbillService.addMbbill(mbbill);
				map.put("result", result);

		return "forward:/Mbbill/list";
	}
	
	//删除慢性病信息
	@RequestMapping("/delete")
	public String delete(Map<String, Object> map, 
			//指定由固定的校验组校�?
			@Validated(value = UserValidateGroupForInsert.class) Mbbill mbbill,Integer id,
			BindingResult bindingResult) {
				
				//保存用户信息，拿到添加操作的结果
				int result = mbbillService.deleteMbbill(id);
				map.put("result", result);
			
		return "forward:/Mbbill/list";
	}
	
    //查看慢性病列表
	@RequestMapping("/list")
	public String list(Map<String, Object> map,
			@RequestParam(value="pageNo", defaultValue="1", required=false) Integer pageNo,
			@RequestParam(value="pageCount", defaultValue="10", required=false) Integer pageCount,
			@RequestParam(value="keyword", required=false) String keyword) {
		
		// 引入PageHelper分页插件，在查询的时候调用，传入页码，以及每页的大小
		PageHelper.startPage(pageNo, pageCount);
		
		// 分页查询得到结果
		List<Mbbill> mbbills;
	
		if (keyword!= null) {
			Mbbill mbbill = new Mbbill();
			/*mbbill.setRunyear(keyword);*/
			mbbills = mbbillService.findByKeyword(mbbill);
		} else {
			mbbills = mbbillService.findByKeyword(null);
		}
			
		PageInfo<Mbbill> page = new PageInfo<Mbbill>(mbbills, 5);
		
		//保存结果集
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		//保存模糊查询条件以便回显
		map.put("keyword", keyword);
		
		return "Mbbill/MbbillList";
	}

}
