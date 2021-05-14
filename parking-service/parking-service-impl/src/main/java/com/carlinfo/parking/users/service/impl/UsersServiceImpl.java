package com.carlinfo.parking.users.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.util.ConstatFinalUtil;
import com.carlinfo.common.util.DateUtil;
import com.carlinfo.common.util.PageInfoUtil;
import com.carlinfo.parking.users.dao.IAAdminsDao;
import com.carlinfo.parking.users.dao.IACommentsDao;
import com.carlinfo.parking.users.dao.IAUsersDao;
import com.carlinfo.parking.users.pojo.AAdmins;
import com.carlinfo.parking.users.pojo.AComments;
import com.carlinfo.parking.users.pojo.AUsers;
import com.carlinfo.parking.users.service.IUsersService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

//用户的service
@Service("usersService")
public class UsersServiceImpl implements IUsersService
{
	/**
	 * dao如何赋值 ~木有写Dao的实现类,无法去顶@Repository(仓库) ~session.getMapper();
	 */
	@Resource
	private IAAdminsDao adminsDao;
	@Resource
	private IAUsersDao usersDao;
	@Resource
	private IACommentsDao commentsDao;

	@Override
	public JSONObject saveOneAdminsService(AAdmins admins)
	{
		JSONObject resultJSON = new JSONObject();
		// 保存
		int res = this.adminsDao.saveOne(admins);
		/* 抛空指针,就是为了测试事务管理器 */
		/*
		 * String str = null ; str.toString() ;
		 */
		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", admins.getId());
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
	public JSONObject updateOneAdminsService(AAdmins admins)
	{
		JSONObject resultJSON = new JSONObject();
		/* 保存 */
		int res = this.adminsDao.updateOne(admins);

		/* 抛空指针,就是为了测试事务管理器 */
		/*
		 * String str = null ; str.toString() ;
		 */

		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", admins.getId());

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
	public JSONObject deleteOneAdminsService(Map<String, Object> condMap)
	{
		JSONObject resultJSON = new JSONObject();
		int res = this.adminsDao.deleteOne(condMap);
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
	public AAdmins findOneAdminsService(Map<String, Object> condMap)
	{
		return this.adminsDao.findOne(condMap);
	}

	@Override
	public List<AAdmins> findCondListAdminsService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
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
			List<AAdmins> adminsList = this.adminsDao.findCondList(condMap);
			/* 设置一下总记录数 */
			pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
			return adminsList;
		}
		return this.adminsDao.findCondList(condMap);
	}

	@Override
	public JSONObject saveOneUsersService(AUsers users)
	{
		JSONObject resultJSON = new JSONObject();
		// 保存
		int res = this.usersDao.saveOne(users);
		/* 抛空指针,就是为了测试事务管理器 */
		/*
		 * String str = null ; str.toString() ;
		 */
		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", users.getId());
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
	public JSONObject updateOneUsersService(AUsers users)
	{
		JSONObject resultJSON = new JSONObject();
		/* 保存 */
		int res = this.usersDao.updateOne(users);

		/* 抛空指针,就是为了测试事务管理器 */
		/*
		 * String str = null ; str.toString() ;
		 */

		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", users.getId());

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
	public JSONObject deleteOneUsersService(Map<String, Object> condMap)
	{
		JSONObject resultJSON = new JSONObject();
		int res = this.usersDao.deleteOne(condMap);
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
	public AUsers findOneUsersService(Map<String, Object> condMap)
	{
		return this.usersDao.findOne(condMap);
	}

	@Override
	public List<AUsers> findCondListUsersService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
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
			List<AUsers> usersList = this.usersDao.findCondList(condMap);
			/* 设置一下总记录数 */
			pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
			return usersList;
		}
		return this.usersDao.findCondList(condMap);
	}

	@Override
	public JSONObject saveOneCommentsService(AComments comments)
	{
		JSONObject resultJSON = new JSONObject();
		// 保存
		int res = this.commentsDao.saveOne(comments);
		/* 抛空指针,就是为了测试事务管理器 */
		/*
		 * String str = null ; str.toString() ;
		 */
		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", comments.getId());
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
	public JSONObject updateOneCommentsService(AComments comments)
	{
		JSONObject resultJSON = new JSONObject();
		/* 保存 */
		int res = this.commentsDao.updateOne(comments);

		/* 抛空指针,就是为了测试事务管理器 */
		/*
		 * String str = null ; str.toString() ;
		 */

		if (res > 0)
		{
			JSONObject dataJSON = new JSONObject();
			dataJSON.put("effect", res);
			dataJSON.put("id", comments.getId());

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
	public JSONObject deleteOneCommentsService(Map<String, Object> condMap)
	{
		JSONObject resultJSON = new JSONObject();
		int res = this.commentsDao.deleteOne(condMap);
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
	public AComments findOneCommentsService(Map<String, Object> condMap)
	{
		return this.commentsDao.findOne(condMap);
	}

	@Override
	public List<AComments> findCondListCommentsService(PageInfoUtil pageInfoUtil, Map<String, Object> condMap)
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
			List<AComments> commentsList = this.commentsDao.findCondList(condMap);
			/* 设置一下总记录数 */
			pageInfoUtil.setTotalRecord(Integer.valueOf(page.getTotal() + ""));
			return commentsList;
		}
		return this.commentsDao.findCondList(condMap);
	}

}
