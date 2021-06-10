package com.carlinfo.users.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.test.BaseTest;
import com.carlinfo.common.util.ConstatFinalUtil;
import com.carlinfo.parking.orders.pojo.AOrders;
import com.carlinfo.parking.orders.pojo.AOrdersHistory;
import com.carlinfo.parking.orders.service.IOrdersService;
import com.carlinfo.parking.users.pojo.AUsers;

/**
 * 订单的测试类
 * @author 张培基
 *
 */
public class OrdersServiceTest extends BaseTest
{
	private IOrdersService ordersService;
	
	/**
	 * 初始化
	 */
	@Before
	public void init()
	{
		/* 为啥要调用父类的方法
		 * 因为了重写 */
		super.init();
		this.ordersService=(IOrdersService) this.ac.getBean("ordersService");
		this.logger.info("ordersService:{}",ordersService);
	}
	
	
	/**
	 * 保存一条订单
	 */
	@Test
	public void saveOneOrdersService()
	{
		AOrders orders = new AOrders() ; 
		orders.setCreateTime(new Date());
		orders.setUpdateTime(new Date());
		JSONObject resultJSON = this.ordersService.saveOneOrdersService(orders);
		ConstatFinalUtil.LOGGER.info("--结果->{}",resultJSON);
	}
	
	/**
	 * 保存一条订单历史
	 */
	@Test
	public void saveOneOrdersHistoryService()
	{
		AOrdersHistory ordersHistory = new AOrdersHistory() ; 
		ordersHistory.setCreateTime(new Date());
		ordersHistory.setUpdateTime(new Date());
		JSONObject resultJSON = this.ordersService.saveOneOrdersHistoryService(ordersHistory);
		ConstatFinalUtil.LOGGER.info("--结果->{}",resultJSON);
	}
	
	/**
	 * 查询一条订单
	 */
	@Test
	public void findOneOrdersService()
	{
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "1");
		AOrders orders =  this.ordersService.findOneOrdersService(condMap);
		ConstatFinalUtil.LOGGER.info("--结果orders->id:{},name:{}",orders.getId(),orders.getUserName());
	
		AUsers users = orders.getUsers() ; 
		ConstatFinalUtil.LOGGER.info("--结果users->id:{},name:{}",users.getId(),users.getEmail());
	}
	
	/**
	 * 查询一条订单
	 */
	@Test
	public void findOneOrdersHistoryService()
	{
		Map<String, Object> condMap = new HashMap<String, Object>();
		condMap.put("id", "1");
		AOrdersHistory ordersHistory =  this.ordersService.findOneOrdersHistoryService(condMap);
		ConstatFinalUtil.LOGGER.info("--结果ordersHistory->id:{},name:{}",ordersHistory.getId(),ordersHistory.getContent());
		AOrders orders =  ordersHistory.getOrders();
		ConstatFinalUtil.LOGGER.info("--结果orders->id:{},name:{}",orders.getId(),orders.getUserName());
	}
}
