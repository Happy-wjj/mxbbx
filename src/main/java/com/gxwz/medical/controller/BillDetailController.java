package com.gxwz.medical.controller;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gxwz.medical.entity.Billdetail;
import com.gxwz.medical.entity.Zcpolicy;
import com.gxwz.medical.service.BillDetailService;
import com.gxwz.medical.service.FamilyService;
import com.gxwz.medical.service.PersinfoService;
import com.gxwz.medical.service.ZcpolicyService;

import com.gxwz.medical.validategroup.UserValidateGroupForInsert;


/**
 * Controller
 * @author ��ʥ��
 *
 */
@Controller
@RequestMapping("/billdetail")
public class BillDetailController {
	/**
	 * FamilyService
	 */
	@Autowired
	private FamilyService familyService;
	@Autowired
	private BillDetailService billdetailService;
	

	@Autowired
	private PersinfoService persinfoService;
	
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
		Billdetail billdetail = billdetailService.findbyId(id);
		map.put("billdetail", billdetail);
		return "page/BilldetailEdit";
	}	
	
	/**
	 * 跳转到输入身份证页面
	 * @param map 携带查询结果和参�?
	 * @param pageNo 目标�?
	 * @param pageCount 每页显示多少记录
	 * @param keyword 查询关键�?
	 * @return 
	 */
	@RequestMapping("/tocardNo")
	public String tocardNo(Map<String, Object> map) {
		return "page/BillCardNo";
	}
	
	/**
	 * 根据身份证号查询是否已经参合
	 * @param map 携带查询结果和参�?
	 * @param pageNo 目标�?
	 * @param pageCount 每页显示多少记录
	 * @param keyword 查询关键�?
	 * @return 
	 */
	@RequestMapping("/cardNo")
	public String cardNo(Map<String, Object> map,
			@RequestParam(value="cardno", required=false) String cardno) {
		
		if (!StringUtils.hasText(cardno)) {
			map.put("msg", "身份证号是必填项�?");
			map.put("result", false);
			//1.2还是停留在原来的界面
			return "page/BillCardNo";
		}
		
		Billdetail billdetail = billdetailService.ValidateCardno(cardno);
		map.put("billdetail", billdetail);
		
		
		// 如果身份证号存在，即查到的结果不为空，则跳转到慢性病添加的页�?
		if(billdetail != null) { 
			map.put("msg", "身份证号已参合！");
			map.put("result", true);
			
			/*根据年份查询封顶�?*/
			
			Date date=new Date();   //获取当前系统时间
			DateFormat format=new SimpleDateFormat("yyyy");
	   		String time = format.format(date); 
	   		Integer timeint = Integer.valueOf(time);//把String 类型转换成int 类型
			Zcpolicy zcpolicy = zcpolicyService.findByYear(timeint);
			/*查询慢�?�病政策表的封顶�?*/
			/*Long maxline = zcpolicy.getMaxline();
			map.put("maxline", maxline);*/
			map.put("zcpolicy", zcpolicy);
			
			return "page/BilldetailEdit";
				
		}else{
			map.put("msg", "身份证号不存在！");
			map.put("result", false);
			return "page/BillCardNo";
		}
	}
	/**
	 * 修改农合经办点信�?
	 * @param map
	 * @param point
	 * @param bindingResult
	 * @param pay 
	 * @return
	 */
	@RequestMapping("/edit")
	public String edit(Map<String, Object> map,
			
	@Valid Billdetail billdetail,BindingResult bindingResult,Integer id) {
				//获取id的�??
				id = billdetail.getId();
				if(billdetail.getBxpay()== null){
					map.put("msg", "本次报销金额是必填项�?");
					map.put("result", false);
					return "forward:/billdetail/cardNo";
				}
				/*已经报销金额=原来的报�?金额+后来再报�?的金�?*/
				Long cost = billdetail.getAllcost();
				Long pay = billdetail.getBxpay();
				Long allcost = cost+pay;
				billdetail.setAllcost(allcost);
				
				/*根据年份查询封顶�?*/
				Date date=new Date();   //获取当前系统时间
				DateFormat format=new SimpleDateFormat("yyyy");
		   		String time = format.format(date); 
		   		Integer timeint = Integer.valueOf(time);//把String 类型转换成int 类型
				Zcpolicy zcpolicy = zcpolicyService.findByYear(timeint);
				Long maxline = zcpolicy.getMaxline();
				
				if(allcost>maxline){
					map.put("msg", "总的慢�?�病报销金额已经超过封顶�?,报销失败�?");
					map.put("result", false);
					return "forward:/billdetail/cardNo";
				}
				//保存慢�?�病报销信息，拿到修改操作的结果
				boolean result = billdetailService.updateBilldetail(billdetail);
				map.put("result", result);
				
				
				return "forward:/billdetail/list";
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
		
		return "page/BilldetailAdd";
	}
	
	@RequestMapping("/add")
	public String add(Map<String, Object> map, 
			//指定由固定的校验组校�?
			@Validated(value = UserValidateGroupForInsert.class) Billdetail billdetail,
			BindingResult bindingResult) {
				Date date=new Date();   //获取当前系统时间
		    	/*DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
				DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   		String time = format.format(date); 
		   		Timestamp time1 = Timestamp.valueOf(time);//把String 类型转换�? Timestamp 类型
		   		billdetail.setTreattime(time1);
		   		billdetail.setRecordtime(time1);
		   		
				//保存用户信息，拿到添加操作的结果
				boolean result = billdetailService.addBilldetail(billdetail);
				map.put("result", result);

		return "forward:/billdetail/list";
	}
	
	@RequestMapping("/delete")
	public String delete(Map<String, Object> map, 
			//指定由固定的校验组校�?
			@Validated(value = UserValidateGroupForInsert.class) Billdetail billdetail,Integer id,
			BindingResult bindingResult) {
				
				//保存用户信息，拿到添加操作的结果
				int result = billdetailService.deleteBilldetail(id);
				map.put("result", result);
			
		return "forward:/billdetail/list";
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
		List<Billdetail> billdetails;
		/*List<Zcpolicy> zcpolicys = null;*/
		
		if (keyword!= null) {
			Billdetail billdetail = new Billdetail();
			billdetail.setBillno(keyword);
			billdetails = billdetailService.findByKeyword(billdetail);
		} else {
			billdetails = billdetailService.findByKeyword(null);
		}
		
		/*根据年份查询封顶�?*/
		Date date=new Date();   //获取当前系统时间
		DateFormat format=new SimpleDateFormat("yyyy");
   		String time = format.format(date); 
   		Integer timeint = Integer.valueOf(time);//把String 类型转换成int 类型
		Zcpolicy zcpolicy = zcpolicyService.findByYear(timeint);
		
		
		// 使用pageInfo包装查询后的结果，只�?要将pageInfo交给页面就行了�??
		// 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
		PageInfo<Billdetail> page = new PageInfo<Billdetail>(billdetails, 5);
		
		
		
		//保存结果集带到页面显�?
		map.put("page", page);
		map.put("pageNo", pageNo);
		map.put("pageCount", pageCount);
		//保存模糊查询条件以便回显
		map.put("keyword", keyword);
		map.put("zcpolicy", zcpolicy);
		
		return "page/BilldetailList";
	}

}
