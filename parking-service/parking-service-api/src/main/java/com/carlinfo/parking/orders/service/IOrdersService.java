package com.carlinfo.parking.orders.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.util.PageInfoUtil;
import com.carlinfo.parking.orders.pojo.AOrders;
import com.carlinfo.parking.orders.pojo.AOrdersHistory;

/**
 * 订单模块的Service
 * @author wangshMac
 *
 */
public interface IOrdersService
{
	/*---- 订单表操作开始 ----*/
	/**
	 * 保存一条订单
	 * @param Orders
	 * @return
	 */
	JSONObject saveOneOrdersService(AOrders orders);
	
	/**
	 * 更新一条订单
	 * @param Orders
	 * @return
	 */
	JSONObject updateOneOrdersService(AOrders orders);
	
	/**
	 * 删除一条订单
	 * @param condMap
	 * @return
	 */
	JSONObject deleteOneOrdersService(Map<String, Object> condMap);
	
	/**
	 * 查询一条订单
	 * @param condMap
	 * @return
	 */
	AOrders findOneOrdersService(Map<String, Object> condMap);
	
	/**
	 * 查询多条订单
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<AOrders> findCondListOrdersService(PageInfoUtil pageInfoUtil,Map<String, Object> condMap);
	/*---- 订单表操作结束 ----*/
	
	/*---- 订单历史表操作开始 ----*/
	/**
	 * 保存一条订单历史
	 * @param OrdersHistory
	 * @return
	 */
	JSONObject saveOneOrdersHistoryService(AOrdersHistory ordersHistory);
	
	/**
	 * 更新一条订单历史
	 * @param OrdersHistory
	 * @return
	 */
	JSONObject updateOneOrdersHistoryService(AOrdersHistory ordersHistory);
	
	/**
	 * 删除一条订单历史
	 * @param condMap
	 * @return
	 */
	JSONObject deleteOneOrdersHistoryService(Map<String, Object> condMap);
	
	/**
	 * 查询一条订单历史
	 * @param condMap
	 * @return
	 */
	AOrdersHistory findOneOrdersHistoryService(Map<String, Object> condMap);
	
	/**
	 * 查询多条订单历史
	 * @param pageInfoUtil
	 * @param condMap
	 * @return
	 */
	List<AOrdersHistory> findCondListOrdersHistoryService(PageInfoUtil pageInfoUtil,Map<String, Object> condMap);
	/*---- 订单历史表操作结束 ----*/
}
