package com.carlinfo.parking.orders.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.util.ConstatFinalUtil;
import com.carlinfo.common.util.PageInfoUtil;
import com.carlinfo.parking.orders.dao.IAOrdersDao;
import com.carlinfo.parking.orders.dao.IAOrdersHistoryDao;
import com.carlinfo.parking.orders.pojo.AOrders;
import com.carlinfo.parking.orders.pojo.AOrdersHistory;
import com.carlinfo.parking.orders.service.IOrdersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 订单的Service
 * 
 * @author wangshMac
 *
 */
@Service("ordersService")
public class OrdersServiceImpl implements IOrdersService
{
	@Resource
	private IAOrdersDao ordersDao;
	@Resource
	private IAOrdersHistoryDao ordersHistoryDao;

	@Override
	public JSONObject saveOneOrdersService(AOrders orders)
	{
		JSONObject resultJSON = new JSONObject();
		// 保存
		int res = this.ordersDao.saveOne(orders);
		/* 抛空指针,就是为了测试事务管理器 */
		/*
		 * String str = null ; str.toString() ;
		 */
		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", orders.getId());
			resultJSON.put("data", dataJSON);
			// 成功
			resultJSON.put("code", "0");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("0"));
		} else
		{
			resultJSON.put("code", "1");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("1"));
		}

		return resultJSON;
	}

	@Override
	public JSONObject updateOneOrdersService(AOrders orders)
	{
		JSONObject resultJSON = new JSONObject();
		/* 保存 */
		int res = this.ordersDao.updateOne(orders);

		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", orders.getId());

			resultJSON.put("data", dataJSON);
			/* 成功 */
			resultJSON.put("code", "0");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("0"));
		} else
		{
			/* 失败 */
			resultJSON.put("code", "1");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("1"));
		}
		return resultJSON;
	}

	@Override
	public JSONObject deleteOneOrdersService(Map<String, Object> condMap)
	{
		JSONObject resultJSON = new JSONObject();
		int res = this.ordersDao.deleteOne(condMap);
		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", condMap.get("id"));

			resultJSON.put("data", dataJSON);
			/* 成功 */
			resultJSON.put("code", "0");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("0"));
		} else
		{
			/* 失败 */
			resultJSON.put("code", "1");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("1"));
		}
		return resultJSON;
	}

	@Override
	public AOrders findOneOrdersService(Map<String, Object> condMap)
	{
		return this.ordersDao.findOne(condMap);
	}

	@Override
	public List<AOrders> findCondListOrdersService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
	{
		/* 专门为关键字增加模糊匹配 */
		if (condMap.get("keyword") != null && !"".equalsIgnoreCase(condMap.get("keyword") + ""))
		{
			condMap.put("keyword", "%" + condMap.get("keyword") + "%");
		}

		if (pageInfoUtil != null)
		{
			/* 得加一个分页的标准 */
			Page page = PageHelper.startPage(pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
			List<AOrders> list = this.ordersDao.findCondList(condMap);
			/* 设置一下总记录数 */
			pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
			return list;
		}
		return this.ordersDao.findCondList(condMap);
	}

	@Override
	public JSONObject saveOneOrdersHistoryService(AOrdersHistory ordersHistory)
	{
		JSONObject resultJSON = new JSONObject();
		// 保存
		int res = this.ordersHistoryDao.saveOne(ordersHistory);
		/* 抛空指针,就是为了测试事务管理器 */
		/*
		 * String str = null ; str.toString() ;
		 */
		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", ordersHistory.getId());
			resultJSON.put("data", dataJSON);
			// 成功
			resultJSON.put("code", "0");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("0"));
		} else
		{
			resultJSON.put("code", "1");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("1"));
		}

		return resultJSON;
	}

	@Override
	public JSONObject updateOneOrdersHistoryService(AOrdersHistory ordersHistory)
	{
		JSONObject resultJSON = new JSONObject();
		/* 保存 */
		int res = this.ordersHistoryDao.updateOne(ordersHistory);

		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", ordersHistory.getId());

			resultJSON.put("data", dataJSON);
			/* 成功 */
			resultJSON.put("code", "0");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("0"));
		} else
		{
			/* 失败 */
			resultJSON.put("code", "1");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("1"));
		}
		return resultJSON;
	}

	@Override
	public JSONObject deleteOneOrdersHistoryService(Map<String, Object> condMap)
	{
		JSONObject resultJSON = new JSONObject();
		int res = this.ordersHistoryDao.deleteOne(condMap);
		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", condMap.get("id"));

			resultJSON.put("data", dataJSON);
			/* 成功 */
			resultJSON.put("code", "0");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("0"));
		} else
		{
			/* 失败 */
			resultJSON.put("code", "1");
			resultJSON.put("info", ConstatFinalUtil.INFO_JSON.get("1"));
		}
		return resultJSON;
	}

	@Override
	public AOrdersHistory findOneOrdersHistoryService(Map<String, Object> condMap)
	{
		return this.ordersHistoryDao.findOne(condMap);
	}

	@Override
	public List<AOrdersHistory> findCondListOrdersHistoryService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
	{
		/* 专门为关键字增加模糊匹配 */
		if (condMap.get("keyword") != null && !"".equalsIgnoreCase(condMap.get("keyword") + ""))
		{
			condMap.put("keyword", "%" + condMap.get("keyword") + "%");
		}

		if (pageInfoUtil != null)
		{
			/* 得加一个分页的标准 */
			Page page = PageHelper.startPage(pageInfoUtil.getCurrentPage(), pageInfoUtil.getPageSize());
			List<AOrdersHistory> list = this.ordersHistoryDao.findCondList(condMap);
			/* 设置一下总记录数 */
			pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
			return list;
		}
		return this.ordersHistoryDao.findCondList(condMap);
	}

}
