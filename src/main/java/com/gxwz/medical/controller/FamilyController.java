package com.gxwz.medical.controller;

import java.io.InputStream;
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

import com.gxwz.medical.entity.Billdetail;
import com.gxwz.medical.entity.Family;
import com.gxwz.medical.entity.Persinfo;
import com.gxwz.medical.entity.Role;
import com.gxwz.medical.entity.Zcpolicy;
import com.gxwz.medical.service.BillDetailService;
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
 * 家庭档案Controller
 * 
 * @author 吴俊杰
 *
 */
@Controller
@RequestMapping("/family")
public class FamilyController {
	/**
	 * FamilyService
	 */
	@Autowired
	private FamilyService familyService;

	@Autowired
	private PersinfoService persinfoService;

	@Autowired
	private BillDetailService billdetailService;

	// 进入家庭档案修改界面
	@RequestMapping("/toEdit")
	public String toEdit(Map<String, Object> map, Integer fid) {
		/* loadUserInfo(map, id); */
		// 根据id查找�?条记�?
		Family family = familyService.findbyId(fid);
		map.put("family", family);
		return "Family/FamilyEdit";
	}

	// 进入参合登记信息新增界面
	@RequestMapping("/toPerAdd")
	public String toPerAdd(Map<String, Object> map, Integer fid) {
		// 根据id查找
		Family family = familyService.findbyId(fid);
		map.put("family", family);
		return "Persinfo/PersinfoAdd";
	}

	// 修改家庭档案操作
	@RequestMapping("/edit")
	public String edit(Map<String, Object> map,
			// 指定由哪个校验组校验
			@Validated(value = UserValidateGroupForUpdate.class) Family family, BindingResult bindingResult,
			Integer fid) {
		// 获取id
		fid = family.getFid();
		// 保存家庭档案信息，拿到修改操作的结果
		boolean result = familyService.updateFamily(family);
		map.put("result", result);
		return "forward:/family/list";
	}

	// 进入新增家庭档案界面
	@RequestMapping("/toAdd")
	public String toAdd(Map<String, Object> map) {

		return "Family/FamilyAdd";
	}

	// 新增家庭档案信息操作
	@RequestMapping("/add")
	public String add(Map<String, Object> map,
			// 指定由固定的校验组校�?
			@Validated(value = UserValidateGroupForInsert.class) Family family, BindingResult bindingResult) {
		// 保存用户信息，拿到添加操作的结果
		family.setPerstate(0);
		boolean result = familyService.addFamily(family);
		map.put("result", result);

		return "forward:/family/list";
	}

	// 删除家庭档案操作
	@RequestMapping("/delete")
	public String delete(Map<String, Object> map,
			// 指定由固定的校验组校
			@Validated(value = UserValidateGroupForInsert.class) Family family, Integer fid,
			BindingResult bindingResult) {

		// 保存用户信息，拿到添加操作的结果
		int result = familyService.deleteFamily(fid);
		map.put("result", result);

		return "forward:/family/list";
	}

	// 查看家庭档案列表、查询关键、结果、页数
	@RequestMapping("/list")
	public String list(Map<String, Object> map,
			@RequestParam(value = "pageNo", defaultValue = "1", required = false) Integer pageNo,
			@RequestParam(value = "pageCount", defaultValue = "10", required = false) Integer pageCount,
			@RequestParam(value = "keyword", required = false) String keyword) {

		// 引入PageHelper分页插件，在查询时调用，传入页码，以及每页的大小
		PageHelper.startPage(pageNo, pageCount);

		// 分页查询得到结果
		List<Family> familys;

		if (keyword != null) {
			Family family = new Family();
			family.setFamilyno(keyword);
			familys = familyService.findByKeyword(family);
		} else {
			familys = familyService.findByKeyword(null);
		}

		PageInfo<Family> page = new PageInfo<Family>(familys, 5);

		// 保存结果集带到页面显示
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		// 保存模糊查询条件以便回显
		map.put("keyword", keyword);

		return "Family/FamilyList";
	}

	//添加参合登记信息
	@RequestMapping("/addper")
	public String addper(Map<String, Object> map,
			// 指定由固定的校验组校
			@Validated(value = UserValidateGroupForInsert.class) Persinfo persinfo, Family family,
			Billdetail billdetail, BindingResult bindingResult, Integer fid) {
		// 获取id的

		fid = family.getFid();
		Family family1 = familyService.findbyId(fid);
		if (family1.getPerstate() != 1) {

			// 将家庭表的id存入参合表里面的familyid
			persinfo.setFamilyid(fid);
			persinfo.setCardno(family1.getCardno());
			boolean result = persinfoService.addPersinfo(persinfo);
			map.put("result", result);

			// 慢性病报销插入数据，表示也参合
			billdetail.setFid(fid);
			billdetail.setCardno(family1.getCardno());
			boolean result1 = billdetailService.addBilldetail(billdetail);
			map.put("result", result1);

			// 将家庭档案设置成参合
			family.setPerstate(1);
			boolean result2 = familyService.updateFamily(family);
			map.put("result2", result2);

		}
		return "forward:/persinfo/list";
	}

	// 取消参合登记
	@RequestMapping("/per")
	public String per(Map<String, Object> map,
			// 指定由固定的校验组校
			@Validated(value = UserValidateGroupForInsert.class) Persinfo persinfo, Family family,
			BindingResult bindingResult, Integer fid) {

		// 获取id的
		fid = family.getFid();
		Family family1 = familyService.findbyId(fid);
		if (family1.getPerstate() != 0) {

			int result = persinfoService.deletePersinfofid(fid);
			map.put("result", result);
			int result2 = billdetailService.deleteBilldetailfid(fid);
			map.put("result2", result2);

			family.setPerstate(0);
			boolean result1 = familyService.updateFamily(family);
			map.put("result1", result1);
		}
		return "page/PerInputName";
	}

}
