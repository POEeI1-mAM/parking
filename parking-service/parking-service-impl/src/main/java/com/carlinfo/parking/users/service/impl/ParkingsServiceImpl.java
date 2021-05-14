package com.carlinfo.parking.users.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.util.ConstatFinalUtil;
import com.carlinfo.common.util.PageInfoUtil;
import com.carlinfo.parking.users.dao.IAParkingsDao;
import com.carlinfo.parking.users.pojo.AParkings;
import com.carlinfo.parking.users.service.IParkingsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service("parkingsService")
public class ParkingsServiceImpl implements IParkingsService
{
	@Resource
	private IAParkingsDao parkingsDao;

	@Override
	public JSONObject saveOneParkingsService(AParkings parkings)
	{
		JSONObject resultJSON = new JSONObject();
		// 保存
		int res = this.parkingsDao.saveOne(parkings);
		/* 抛空指针,就是为了测试事务管理器 */
		/*
		 * String str = null ; str.toString() ;
		 */
		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", parkings.getId());
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
	public JSONObject updateOneParkingsService(AParkings parkings)
	{
		JSONObject resultJSON = new JSONObject();
		/* 保存 */
		int res = this.parkingsDao.updateOne(parkings);

		/* 抛空指针,就是为了测试事务管理器 */
		/*
		 * String str = null ; str.toString() ;
		 */

		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", parkings.getId());

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
	public JSONObject deleteOneParkingsService(Map<String, Object> condMap)
	{
		JSONObject resultJSON = new JSONObject();
		int res = this.parkingsDao.deleteOne(condMap);
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
	public AParkings findOneParkingsService(Map<String, Object> condMap)
	{
		return this.parkingsDao.findOne(condMap);
	}

	@Override
	public List<AParkings> findCondListParkingsService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
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
			List<AParkings> adminsList = this.parkingsDao.findCondList(condMap);
			/* 设置一下总记录数 */
			pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
			return adminsList;
		}
		return this.parkingsDao.findCondList(condMap);
	}

}
