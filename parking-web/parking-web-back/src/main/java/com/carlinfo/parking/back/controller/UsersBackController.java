package com.carlinfo.parking.back.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carlinfo.common.controller.BaseController;
import com.carlinfo.common.util.ConstatFinalUtil;
import com.carlinfo.common.util.PageInfoUtil;
import com.carlinfo.parking.users.pojo.AAdmins;
import com.carlinfo.parking.users.service.IUsersService;

/**
 * 后台管理员的Controller
 * 必须登陆以后才能访问/back/
 */
@Controller
@RequestMapping("/back/admins/")
public class UsersBackController extends BaseController
{
	@Resource
	private IUsersService usersService;
	
	/**
	 * 登陆后的首页
	 * 
	 * 想访问此方法,一定得是类上的面requestmapping+方法上面的requestmapping
	 * @return
	 * jsp的路径:jsp路径:前缀+Controller方法的返回值+后缀
	 */
	@RequestMapping("/main")
	public String main()
	{
		ConstatFinalUtil.LOGGER.info("==main==");
		return "/back/main" ; 
	}
	@RequestMapping("/welcome")
	public String welcome()
	{
		ConstatFinalUtil.LOGGER.info("==welcome==");
		return "/back/welcome" ; 
	}
	@RequestMapping("/adminsList")
	public String usersList(String keyword , String status , String st,String ed , HttpServletRequest request,Model model)
	{
		ConstatFinalUtil.LOGGER.info("====adminsList====");
		/* 所有的字符串都要进行为空的判断 */
		if(keyword == null)
		{
			keyword = "" ; 
		}
		
		if(status == null)
		{
			status = "" ; 
		}
		
		if(st == null)
		{
			st = "" ; 
		}
		if(ed == null)
		{
			ed = "" ; 
		}
		
		Date stDate = null ; 
		Date edDate = null ; 
		
		/* 如何把字符串变成时间呢? */
		if(!"".equalsIgnoreCase(st) && !"".equalsIgnoreCase(ed))
		{
			stDate = this.dateUtil.strToDateTime(st);
			edDate = this.dateUtil.strToDateTime(ed);
		}
		
		/* 把所有的条件由死的变成活的 */
		PageInfoUtil pageInfoUtil = this.proccedPageInfoUtil(request);
		
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("keyword", keyword);
		/* 如果状态不为空字符串,就成功 */
		if(!"".equalsIgnoreCase(status))
		{
			condMap.put("status", status);
		}
		condMap.put("stDate", stDate);
		condMap.put("edDate", edDate);
		List<AAdmins> adminsList = this.usersService.findCondListAdminsService(pageInfoUtil , condMap);
		/* 将结果放到四大作用域中 */
		model.addAttribute("adminsList", adminsList);
		model.addAttribute("pageInfoUtil", pageInfoUtil);
		
		/* 存储搜索的条件 */
		model.addAttribute("keyword", keyword);
		model.addAttribute("status", status);
		model.addAttribute("st", st);
		model.addAttribute("ed", ed);
		/* 
		 * 国际资源解析器:
		 * 前缀和后缀
		 * */
		return "/back/admins/adminsList" ;
	}
}
