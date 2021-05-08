package com.gxwz.medical.controller;

import java.util.List;
import java.util.Map;

import com.gxwz.medical.entity.City;
import com.gxwz.medical.entity.Town;
import com.gxwz.medical.service.CityService;
import com.gxwz.medical.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxwz.medical.entity.Area;
import com.gxwz.medical.service.AreaService;
import com.gxwz.medical.validategroup.UserValidateGroupForInsert;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.inject.Inject;

/**
 * 行政区域管理Controller
 * @author 吴俊杰
 *
 */
@Controller
@RequestMapping("/area")
public class AreaController {

	/**
	 * PointService
	 */
	@Inject
	private AreaService areaService;

	@Inject
	private CityService cityService;

	//进入写修改行政区域信息界面
	@RequestMapping("/toEdit")
	public String toEdit(Map<String, Object> map,Integer id) {
		//根据id查找
		Area area = areaService.findbyId(id);
		map.put("area", area);
		return "Area/AreaEdit";
	}	
	
	
	//修改行政区域信息
	@RequestMapping("/edit")
	public String edit(Map<String, Object> map,	
			Area area,BindingResult bindingResult,String id) {
				//获取id
				id = area.getId();
				System.out.println("id"+id);
				System.out.println(area);//保存信息，拿到修改操作的结果
				boolean result = areaService.updateArea(area);
				map.put("result", result);
				return "forward:/area/list";
	}

//	 //进入新增行政区域界面
//	@RequestMapping("/toAdd")
//	public String toAdd(Map<String, Object> map,ModelMap map1) {
//		map1.addAttribute("provinceList", cityService.getAllProvince());
//		return "Area/AreaAdd";
//	}
	
	 //新增行政区域信息操作
	@RequestMapping("/add")
	public String add(Map<String, Object> map, 
		
			@Validated(value = UserValidateGroupForInsert.class) Area area,
			BindingResult bindingResult,Integer id) {
				//保存用户信息，拿到添加操作的结果
				boolean result = areaService.addArea(area);
				map.put("result", result);

		return "forward:/area/list";
	}
	
	 //删除行政区域信息操作
	@RequestMapping("/delete")
	public String delete(Map<String, Object> map, 
			
			@Validated(value = UserValidateGroupForInsert.class) Area area,Integer id,
			BindingResult bindingResult) {

				//保存用户信息，拿到添加操作的结果
				int result = areaService.deleteArea(id);
				map.put("result", result);
			
		return "forward:/area/list";
	}
	
	 //查看行政区域信息列表
	@RequestMapping("/list")
	public String list(Map<String, Object> map,
			@RequestParam(value="pageNo", defaultValue="1", required=false) Integer pageNo,
			@RequestParam(value="pageCount", defaultValue="10", required=false) Integer pageCount,
			@RequestParam(value="cityno", required=false) String cityno) {
		
		// 引入PageHelper分页插件，在查询的时候调用，传入页码，以及每页的大小
		PageHelper.startPage(pageNo, pageCount);
		
		// 分页查询得到结果
		List<Area> areas;
		if (cityno!= null) {
			Area area = new Area();
			area.setCityno(cityno);
			areas = areaService.findByKeyword(area);
		} else {
			areas = areaService.findByKeyword(null);
		}
		
		PageInfo<Area> page = new PageInfo<Area>(areas, 5);
		
		//保存结果集
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		//保存模糊查询条件以便回显
		map.put("cityno", cityno);
		
		return "Area/AreaList";
	}


}
