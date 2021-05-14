package com.carlinfo.common.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.carlinfo.common.util.DateUtil;
import com.carlinfo.common.util.PageInfoUtil;

/**
 * Controller里面公共的代码
 *
 */
public class BaseController
{
	@Resource
	protected DateUtil dateUtil;

	/**
	 * 根据所有的列表页面共同的特别:列表分页;
	 * 将此代码抽取到BaseServlet中
	 * 
	 * 不用将搜索也抽取出来;因为搜索的条件多种多样;而分页的条件是固定的;
	 * 
	 * @param request
	 * @return
	 */
	protected PageInfoUtil proccedPageInfoUtil(HttpServletRequest request)
	{
		/*
		 * 查询管理员列表
		 * 把原来在测试类中写的代码拿过来
		 * 条件全部是写死的,将条件变成活的,从页面中来
		 * */
		String currentPage = request.getParameter("currentPage");
		String pageSize = request.getParameter("pageSize");
		/* 分页对象 */
		PageInfoUtil pageInfoUtil = new PageInfoUtil() ; 
		try
		{
			pageInfoUtil.setCurrentPage(Integer.valueOf(currentPage));
			pageInfoUtil.setPageSize(Integer.valueOf(pageSize));
		} catch (NumberFormatException e)
		{
		}
		return pageInfoUtil ; 
	}

}
