package com.carlinfo.parking.users.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.util.PageInfoUtil;
import com.carlinfo.parking.users.pojo.AAdmins;
import com.carlinfo.parking.users.pojo.AComments;
import com.carlinfo.parking.users.pojo.AUsers;

public interface IUsersService
{
	/* == 管理员操作开始 == */
	/**
	 * 保存一条管理员
	 * @param admins
	 * @return
		{
			// 响应码
			"code":"0",
			// 响应信息
			"info":"",
			// 数据
			"data":
			{
				// 影响条数;sql执行以后对数据库的影响条数
				"effect":"",
				// id,保存的时候要主键
				"id":""
			}
		}
	 */
	JSONObject saveOneAdminsService(AAdmins admins);
	
	/**
	 * 更新一条管理员
	 * @param admins
	 * @return
	 */
	JSONObject updateOneAdminsService(AAdmins admins);
	
	/**
	 * 删除一条管理员
	 * @param condMap
	 * @return
	 */
	JSONObject deleteOneAdminsService(Map<String, Object> condMap);
	
	/**
	 * 查询一条管理员
	 * @param condMap
	 * @return
	 */
	AAdmins findOneAdminsService(Map<String, Object> condMap);
	
	/**
	 * 查询多条管理员
	 * @param condMap
	 * @return
	 */
	List<AAdmins> findCondListAdminsService(PageInfoUtil pageInfoUtil,Map<String, Object> condMap);
	
	/* == 管理员操作结束 == */
	
	
JSONObject saveOneUsersService(AUsers users);
	
	/**
	 * 更新一条管理员
	 * @param Users
	 * @return
	 */
	JSONObject updateOneUsersService(AUsers users);
	
	/**
	 * 删除一条管理员
	 * @param condMap
	 * @return
	 */
	JSONObject deleteOneUsersService(Map<String, Object> condMap);
	
	/**
	 * 查询一条管理员
	 * @param condMap
	 * @return
	 */
	AUsers findOneUsersService(Map<String, Object> condMap);
	
	/**
	 * 查询多条管理员
	 * @param condMap
	 * @return
	 */
	List<AUsers> findCondListUsersService(PageInfoUtil pageInfoUtil,Map<String, Object> condMap);

	
	JSONObject saveOneCommentsService(AComments comments);
	
	
	JSONObject updateOneCommentsService(AComments comments);
	
	
	JSONObject deleteOneCommentsService(Map<String, Object> condMap);
	
	
	AComments findOneCommentsService(Map<String, Object> condMap);
	
	List<AComments> findCondListCommentsService(PageInfoUtil pageInfoUtil,Map<String, Object> condMap);
}
