package com.carlinfo.users.test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.test.BaseTest;
import com.carlinfo.common.util.ConstatFinalUtil;
import com.carlinfo.common.util.PageInfoUtil;
import com.carlinfo.parking.users.pojo.AAdmins;
import com.carlinfo.parking.users.pojo.AComments;
import com.carlinfo.parking.users.pojo.AParkings;
import com.carlinfo.parking.users.pojo.AUsers;
import com.carlinfo.parking.users.service.IParkingsService;
import com.carlinfo.parking.users.service.IUsersService;

public class UsersServiceTest extends BaseTest
{
	private IUsersService usersService;
	private IParkingsService parkingsService;
	/**
	 * 初始化
	 */
	@Before
	public void init()
	{
		/* 为啥要调用父类的方法
		 * 因为了重写 */
		super.init();
		this.usersService = (IUsersService) this.ac.getBean("usersService");
		this.logger.info("usersService:{}",usersService);
		this.parkingsService=(IParkingsService) this.ac.getBean("parkingsService");
		this.logger.info("parkingsService:{}",parkingsService);
	}
	
	
	/**
	 * 保存一条管理员
	 */
	@Test
	public void saveOneAdminsService()
	{
		AAdmins admins = new AAdmins() ; 
		admins.setEmail("11@11.com");
		admins.setCreateTime(new Date());
		admins.setUpdateTime(new Date());
		admins.setLastLoginTime(new Date());
		JSONObject resultJSON = this.usersService.saveOneAdminsService(admins);
		ConstatFinalUtil.LOGGER.info("--结果->{}",resultJSON);
	}
	
	/**
	 * 更新一条管理员
	 */
	@Test
	public void updateOneAdminsService()
	{
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("id", "2");
		AAdmins admins = this.usersService.findOneAdminsService(condMap);
		
		/* 修改值 */
		admins.setEmail(admins.getEmail() + "_aaa");
		admins.setUpdateTime(new Date());
		
		JSONObject resultJSON = this.usersService.updateOneAdminsService(admins);
		ConstatFinalUtil.LOGGER.info("--结果->{}",resultJSON);
	}
	
	/**
	 * 删除一条用户
	 */
	@Test
	public void deleteOneAdminsService()
	{
		Map<String, Object> condMap = new HashMap<String,Object>();
		/* 按照Id查询 */
		condMap.put("id", "5");
		JSONObject resultJSON = this.usersService.deleteOneAdminsService(condMap);
		ConstatFinalUtil.LOGGER.info("--结果->{}",resultJSON);
	}
	
	
	/**
	 * 查询一条管理员
	 */
	@Test
	public void findOneAdminsService()
	{
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("id", "1");
		AAdmins admins = this.usersService.findOneAdminsService(condMap);
		ConstatFinalUtil.LOGGER.info("admins:id:{},email:{}",admins.getId(),admins.getEmail());
	}
	
	/**
	 * 查询多条管理员
	 */
	@Test
	public void findCondListAdminsService()
	{
		Map<String, Object> condMap = new HashMap<String,Object>();
		/* 分页 */
		PageInfoUtil pageInfoUtil = new PageInfoUtil() ; 
		pageInfoUtil.setCurrentPage(1000000);
		/* 搜索的条件 */
		//condMap.put("keyword", "2");
		condMap.put("status", "0");
		//condMap.put("stDate", new Date());
		//condMap.put("edDate", new Date());
		/*List<AAdmins> adminsList = this.usersService.findCondListService(null , condMap);*/
		List<AAdmins> adminsList=this.usersService.findCondListAdminsService(pageInfoUtil, condMap);
		for (Iterator iterator = adminsList.iterator(); iterator.hasNext();)
		{
			AAdmins admins = (AAdmins) iterator.next();
			ConstatFinalUtil.LOGGER.info("admins:id:{},email:{}",admins.getId(),admins.getEmail());
		}
		
		ConstatFinalUtil.LOGGER.info("分页信息:{}",pageInfoUtil);
	}
	
	
	@Test
	public void saveOneUsersService()
	{
		AUsers users = new AUsers() ; 
		users.setEmail("11@11.com");
		users.setCreateTime(new Date());
		users.setUpdateTime(new Date());
		users.setLastLoginTime(new Date());
		JSONObject resultJSON = this.usersService.saveOneUsersService(users);
		ConstatFinalUtil.LOGGER.info("--结果->{}",resultJSON);
	}

	@Test
	public void updateOneUsersService()

	{
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("id", "2");
		AUsers users = this.usersService.findOneUsersService(condMap);
		
		/* 修改值 */
		users.setEmail(users.getEmail() + "_aaa");
		users.setUpdateTime(new Date());
		
		JSONObject resultJSON = this.usersService.updateOneUsersService(users);
		ConstatFinalUtil.LOGGER.info("--结果->{}",resultJSON);
	}
	
	@Test
	public void deleteOneUsersService()
	{
		Map<String, Object> condMap = new HashMap<String,Object>();
		/* 按照Id查询 */
		condMap.put("id", "5");
		JSONObject resultJSON = this.usersService.deleteOneUsersService(condMap);
		ConstatFinalUtil.LOGGER.info("--结果->{}",resultJSON);
	}
	
	@Test
	public void findOneUsersService()
	{
		Map<String, Object> condMap = new HashMap<String,Object>();
		condMap.put("id", "2");
		AUsers users = this.usersService.findOneUsersService(condMap);
		ConstatFinalUtil.LOGGER.info("admins:id:{},email:{}",users.getId(),users.getEmail());
	}
	
	@Test
	public void findCondListUsersService()
	{
		Map<String, Object> condMap = new HashMap<String,Object>();
		/* 分页 */
		PageInfoUtil pageInfoUtil = new PageInfoUtil() ; 
		pageInfoUtil.setCurrentPage(1000000);
		/* 搜索的条件 */
		//condMap.put("keyword", "2");
		condMap.put("status", "0");
		//condMap.put("stDate", new Date());
		//condMap.put("edDate", new Date());
		/*List<AAdmins> adminsList = this.usersService.findCondListService(null , condMap);*/
		List<AUsers> usersList=this.usersService.findCondListUsersService(pageInfoUtil, condMap);
		for (Iterator iterator = usersList.iterator(); iterator.hasNext();)
		{
			AUsers users = (AUsers) iterator.next();
			ConstatFinalUtil.LOGGER.info("admins:id:{},email:{}",users.getId(),users.getEmail());
		}
		
		ConstatFinalUtil.LOGGER.info("分页信息:{}",pageInfoUtil);
	}
	
	@Test
	public void saveOneCommentsService()
	{
		AComments comments = new AComments() ; 
		comments.setContent("大家好");
		comments.setCreateTime(new Date());
		comments.setUpdateTime(new Date());
		
		JSONObject resultJSON = this.usersService.saveOneCommentsService(comments);
		ConstatFinalUtil.LOGGER.info("--结果->{}",resultJSON);
	}
	
	@Test
	public void saveOneParkingsService()
	{
		AParkings parkings = new AParkings() ; 
		parkings.setName("润泰停车场");
		parkings.setLocal("nanyang");
		parkings.setCreateTime(new Date());
		parkings.setUpdateTime(new Date());
		
		JSONObject resultJSON = this.parkingsService.saveOneParkingsService(parkings);
		ConstatFinalUtil.LOGGER.info("--结果->{}",resultJSON);
	}
}
