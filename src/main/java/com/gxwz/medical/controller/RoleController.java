package com.gxwz.medical.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.gxwz.medical.entity.Function;
import com.gxwz.medical.entity.Role;
import com.gxwz.medical.service.FunctionService;
import com.gxwz.medical.service.RoleService;

/**
 * 角色Controller
 * @author 李圣�?
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController {

	/**
	 * 角色Service
	 */
	@Autowired
	private RoleService roleService;
	
	/**
	 * 功能Service
	 */
	@Autowired
	private FunctionService functionService;
	
	/**
	 * 更新权限
	 * @param map
	 * @param roleid 角色id
	 * @param funids 用户选中的权限id
	 * @return
	 */
	@RequestMapping("/updateRoleRight")
	public String updateRoleRight(Map<String, Object> map, Integer roleid, Integer funids[]) {
		
		//查出角色信息
		Role role = roleService.findById(roleid);
		
		//修改权限列表
		boolean result = roleService.updateRoleright(roleid, funids);
		map.put("result", result);
		
		if (result == true) {
			map.put("msg", "修改角色[" + role.getRolename() + "]的权限信息成功！");
		} else {
			map.put("msg", "修改角色[" + role.getRolename() + "]的权限信息失败！");
		}
		
		return "forward:/role/roles";
	}
	
	/**
	 * 进入权限页面
	 * @return
	 */
	@RequestMapping("/toRoleRight")
	public String toRoleRight(Map<String, Object> map, Integer roleid) {
		
		//得到权限列表
		Role role = roleService.findByIdCascade(roleid);
		map.put("role", role);
		
		//得到�?有功能信�?
		List<Function> functions = functionService.getFunctionList(null);
		map.put("functionList", functions);
		
		return "role/roleright";
	}
	
	/**
	 * 进入修改页面
	 * @return
	 */
	@RequestMapping("/toModify")
	public String toModify(Map<String, Object> map, Integer roleid) {
		
		Role role = roleService.findById(roleid);
		map.put("role", role);
		
		return "role/rolemodify";
	}
	
	/**
	 * 修改角色
	 * @return
	 */
	@RequestMapping("/modifyRole")
	public String modifyRole(Map<String, Object> map, @Valid Role role, BindingResult bindingResult) {
		
		//�?查校验是否出�?
		if(bindingResult.hasErrors()){
			List<ObjectError> list = bindingResult.getAllErrors();
			ObjectError oe = list.get(0);
			
			//校验失败信息
			map.put("result", false);
			map.put("msg", oe.getDefaultMessage() + "修改角色[" + role.getRolename() + "]失败�?");
		} else {
			//功能名称查重
			boolean hasSame = roleService.hasSameRole(role.getRoleid(), role.getRolename());
			
			if (hasSame == false) { //功能名称不重�?
				
				//保存功能信息，拿到修改操作的结果
				boolean result = roleService.updateRole(role);
				map.put("result", result);
				
				//根据操作结果生成提示信息
				if (result == true) {  //修改成功且无重复
					
					map.put("msg", "修改角色[" + role.getRolename() + "]成功�?");
				} else {
					
					map.put("msg", "修改角色[" + role.getRolename() + "]失败�?");
				}
				
			} else {
				map.put("result", false);
				map.put("msg", "角色名称[" + role.getRolename() + "]重复，修改角色失败！");
			}
		}
			
		return "forward:/role/roles";
		
	}
	
	/**
	 * 进入添加页面
	 * @return
	 */
	@RequestMapping("/toAdd")
	public String toAdd() {
		
		return "role/roleadd";
	}
	
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping("/addRole")
	public String addRole(Map<String, Object> map, @Valid Role role, BindingResult bindingResult) {
		
		//�?查校验是否出�?
		if(bindingResult.hasErrors()){
			List<ObjectError> list = bindingResult.getAllErrors();
			ObjectError oe = list.get(0);
			
			//校验失败信息
			map.put("result", false);
			map.put("msg", oe.getDefaultMessage() + "添加角色[" + role.getRolename() + "]失败�?");
		} else {
			//功能名称查重
			boolean hasSame = roleService.hasSameRole(null, role.getRolename());
			
			if (hasSame == false) { //功能名称不重�?
				
				//保存功能信息，拿到添加操作的结果
				boolean result = roleService.addRole(role);
				map.put("result", result);
				
				//根据操作结果生成提示信息
				if (result == true) {  //添加成功且无重复
					
					map.put("msg", "添加角色[" + role.getRolename() + "]成功�?");
				} else {
					
					map.put("msg", "添加角色[" + role.getRolename() + "]失败�?");
				}
				
			} else {
				map.put("result", false);
				map.put("msg", "角色名称[" + role.getRolename() + "]重复，添加角色失败！");
			}
		}
			
		return "forward:/role/roles";
		
	}
	
	/**
	 * 模糊查询
	 * @param map 容器
	 * @param pageNo 目标�?
	 * @param pageCount 每页记录�?
	 * @param roleid 角色id
	 * @return
	 */
	@RequestMapping("/roles")
	public String roles(Map<String, Object> map,
			@RequestParam(value="pageNo", defaultValue="1", required=false) Integer pageNo,
			@RequestParam(value="pageCount", defaultValue="10", required=false) Integer pageCount,
			@RequestParam(value="role_id", required=false) Integer role_id) {
		
		// 引入PageHelper分页插件
		// 在查询之前只�?要调用，传入页码，以及每页的大小
		PageHelper.startPage(pageNo, pageCount);
		
		// 分页查询得到结果�?
		List<Role> roles;
		
		if (role_id != null) {
			Role role = new Role();
			role.setRoleid(role_id);
			roles = roleService.getByKeyword(role);
		} else {
			roles = roleService.getByKeyword(null);
		}
		
		
		// 使用pageInfo包装查询后的结果，只�?要将pageInfo交给页面就行了�??
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo<Role> page = new PageInfo<Role>(roles, 5);
		
		//保存结果集带到页面显�?
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		map.put("allList", roleService.getByKeyword(null));
		
		//保存模糊查询条件以便回显
		map.put("role_id", role_id);
		
		return "role/roleManage";
	}
	
}
