package com.carlinfo.users.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.test.BaseTest;
import com.carlinfo.common.util.ConstatFinalUtil;
import com.carlinfo.parking.orders.pojo.AOrders;
import com.carlinfo.parking.orders.pojo.AOrdersHistory;
import com.carlinfo.parking.orders.service.IOrdersService;
import com.carlinfo.parking.users.pojo.AAdmins;
import com.carlinfo.parking.users.service.IParkingsService;
import com.carlinfo.parking.users.service.IUsersService;

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
}
