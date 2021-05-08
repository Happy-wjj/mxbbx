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
import com.gxwz.medical.entity.Zcpolicy;
import com.gxwz.medical.entity.Point;
import com.gxwz.medical.service.RoleService;
import com.gxwz.medical.service.PointService;
import com.gxwz.medical.service.UserService;
import com.gxwz.medical.service.ZcpolicyService;
import com.gxwz.medical.util.MD5Helper;
import com.gxwz.medical.validategroup.UserValidateGroupForInsert;
import com.gxwz.medical.validategroup.UserValidateGroupForPasswordModify;
import com.gxwz.medical.validategroup.UserValidateGroupForUpdate;
import com.gxwz.medical.validategroup.UserValidateGroupForUserModify;

/**
 * 慢性病政策Controller
 * @author 吴俊杰
 *
 */
@Controller
@RequestMapping("/zcpolicy")
public class ZcpolicyController {
	
	/**
	 * PointService
	 */
	@Autowired
	private PointService pointService;

	@Autowired
	private ZcpolicyService zcpolicyService;
	/**
	 * 进入修改信息的界�?
	 * @param map
	 * @param userid
	 * @return
	 */
	@RequestMapping("/toEdit")
	public String toEdit(Map<String, Object> map,Integer id) {
		/*loadUserInfo(map, id);*/
		//根据id查找�?条记�?
		Zcpolicy zcpolicy = zcpolicyService.findbyId(id);
		map.put("zcpolicy", zcpolicy);
		return "page/ZcpolicyEdit";
	}	
	
	
	/**
	 * 修改农合经办点信�?
	 * @param map
	 * @param point
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Map<String, Object> map,
			//指定由哪个校验组校验
			/*@Validated(value=UserValidateGroupForUpdate.class) */
			Zcpolicy zcpolicy,BindingResult bindingResult,Integer id) {
				//获取id的�??
				id = zcpolicy.getId();
				System.out.println("id"+id);
				//保存学生信息，拿到修改操作的结果
				boolean result = zcpolicyService.updateZcpolicy(zcpolicy);
				map.put("result", result);
				return "forward:/zcpolicy/list";
	}
	
	private String getParameters(String string) {
		return null;
	}

	/**
	 * 进入添加网点信息界面
	 * @param map
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd(Map<String, Object> map) {
		
		return "page/ZcpolicyAdd";
	}
	
	@RequestMapping("/add")
	public String add(Map<String, Object> map, 
			//指定由固定的校验组校�?
			@Validated(value = UserValidateGroupForInsert.class) Zcpolicy zcpolicy,
			BindingResult bindingResult) {
				//保存用户信息，拿到添加操作的结果
				boolean result = zcpolicyService.addZcpolicy(zcpolicy);
				map.put("result", result);

		return "forward:/zcpolicy/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Map<String, Object> map, 
			//指定由固定的校验组校�?
			@Validated(value = UserValidateGroupForInsert.class) Zcpolicy zcpolicy,Integer id,
			BindingResult bindingResult) {
				
				//保存用户信息，拿到添加操作的结果
				int result = zcpolicyService.deleteZcpolicy(id);
				map.put("result", result);
			
		return "forward:/zcpolicy/list";
	}
	
	/**
	 * 查看列表
	 * @param map 携带查询结果和参�?
	 * @param pageNo 目标�?
	 * @param pageCount 每页显示多少记录
	 * @param keyword 查询关键�?
	 * @return 
	 */
	@RequestMapping("/list")
	public String list(Map<String, Object> map,
			@RequestParam(value="pageNo", defaultValue="1", required=false) Integer pageNo,
			@RequestParam(value="pageCount", defaultValue="10", required=false) Integer pageCount,
			@RequestParam(value="keyword", required=false) String keyword) {
		
		// 引入PageHelper分页插件
		// 在查询之前只�?要调用，传入页码，以及每页的大小
		PageHelper.startPage(pageNo, pageCount);
		
		// 分页查询得到结果�?
		List<Zcpolicy> zcpolicys;
		
		if (keyword!= null) {
			Zcpolicy zcpolicy = new Zcpolicy();
			/*zcpolicy.setRunyear(keyword);*/
			zcpolicys = zcpolicyService.findByKeyword(zcpolicy);
		} else {
			zcpolicys = zcpolicyService.findByKeyword(null);
		}
		
		// 使用pageInfo包装查询后的结果，只�?要将pageInfo交给页面就行了�??
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo<Zcpolicy> page = new PageInfo<Zcpolicy>(zcpolicys, 5);
		
		//保存结果集带到页面显�?
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		//保存模糊查询条件以便回显
		map.put("keyword", keyword);
		
		return "page/ZcpolicyList";
	}

}
