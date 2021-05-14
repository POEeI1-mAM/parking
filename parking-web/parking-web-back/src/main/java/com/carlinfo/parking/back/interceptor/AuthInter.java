package com.carlinfo.parking.back.interceptor;


import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.util.ConstatFinalUtil;
import com.carlinfo.common.util.HttpUtil;
import com.carlinfo.parking.users.pojo.AAdmins;
import com.carlinfo.parking.users.pojo.AAdminsEnum;
import com.carlinfo.parking.users.service.IUsersService;


/**
 * 拦截器
 * 注解一定得起名字,因为在其它地方使用到了
 */
@Component("authInter")
public class AuthInter implements HandlerInterceptor
{
	@Resource
	private IUsersService usersService;
	
	/**
	 * 拦截器中的三个方法此方法先执行
	 * 返回值:如果是true,放行,如果是false,拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
	{
		ConstatFinalUtil.LOGGER.info("==拦截器执行==");
		/* 用户中心登陆地址 */
		String loginPath = ConstatFinalUtil.SYS_CONFIG_JSON.getString("loginPath"); 
		/*
		 * 判断session是否有值
		 * 获取token;验证token是否合法
		 * 直接跳转到登陆页面
		 * */
		/* 请获取到returnUrl */
		/* 打印一下当前访问的URL
		 * http://localhost:8080/usercenter_20180108_model2/back/AdminsBackServlet
		 *  */
		String currUrl = request.getRequestURL() + "" ; 
		/* 链接?后面的内容;
		 * 如果?后面木有内容,返回是null
		 * method=adminsList
		 *  */
		String queryStr = request.getQueryString() ; 
		/* url得拼装起来 */
		String url = currUrl ; 
		if(queryStr != null)
		{
			url = url + "?" + queryStr ; 
		}
		System.out.println("=currUrl==" + currUrl);
		System.out.println("=queryStr==" + queryStr);
		System.out.println("url====" + url);
		
		/* 巡逻员,验票 
		 * */
		HttpSession session = request.getSession() ; 
		AAdmins AAdmins = (AAdmins) session.getAttribute("admins");
		if(AAdmins != null)
		{
			/* 已经登陆过,不需要再登陆了,令牌还是合法的 */
			return true ; 
		}
		
		/* 此用户木有地方买票
		 * 每一次和第二次的区别是url参数中多了一个token;
		 * 这个token是用户中心带上去的
		 *  */
		String token = request.getParameter("token");
		if(token != null && !"".equalsIgnoreCase(token))
		{
			HttpUtil httpUtil = new HttpUtil() ; 
			/* token肯定有值
			 * 请求用户中心,验证此token是不是合法;
			 * 浏览器,把Url贴出来,到浏览器中打回车,就可以看到效果
			 *  */
			String requestUrl = ConstatFinalUtil.SYS_CONFIG_JSON.getString("CommonInfo"); 
			/* 参数 */
			/*String json = "{'ver':'1', 'method':'verifyToken','pubKey':'aa','sign':'','data':{'token':'1111'}}"; */
			/* 拼装上行的JSON */
			JSONObject reqJSON = new JSONObject() ; 
			reqJSON.put("ver", "1");
			reqJSON.put("method", "verifyToken");
			reqJSON.put("pubKey", "aa");
			reqJSON.put("sign", "");
			
			JSONObject reqDataJSON = new JSONObject() ; 
			reqDataJSON.put("token", token);
			
			reqJSON.put("data", reqDataJSON);
			System.out.println("==请求参数==" + reqJSON.toJSONString());
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", URLEncoder.encode(reqJSON.toJSONString(), "UTF-8"));
			String result = httpUtil.methodGet(requestUrl, paramsMap);
			System.out.println("==返回结果==" + result);
			/* 解析下行的JSON */
			JSONObject resultJSON = (JSONObject) JSON.parse(result);
			if("0".equalsIgnoreCase(resultJSON.getString("code")))
			{
				JSONObject resultDataJSON = (JSONObject) resultJSON.get("data");
				JSONObject adminsJSON = (JSONObject) resultDataJSON.get("admins");
				System.out.println("====adminsJSON===" + adminsJSON);
				/* 为了减少服务器的带宽,已经验证过的token,自己存储一下
				 * 存储自己的session中 */
				
				/* 将用户中心管理员的信息同步到商城的数据库中 */
				AAdmins admins = this.operAdminsSync(adminsJSON);
				/* session存储的是商城项目中的管理员信息 */
				session.setAttribute("admins", admins);
				return true ; 
			}
		}
		/* 木有登陆 */
		/*request.getRequestDispatcher(loginPath).forward(request, res);
		return ; */
		/* 这个是在跳转之前,加上的returnUrl */
		loginPath = loginPath + "&returnUrl="+ URLEncoder.encode(url, "UTF-8") ;
		System.out.println("===loginPath=======>" + loginPath);
		response.sendRedirect(loginPath);
		return false;
	}
	
	/**
	 * {
			"qq": "33",
			"statusStr": "启用",
			"loginFailedTime": 1515653290000,
			"photoPath": "1",
			"roleId": 2,
			"pubTime": 1515653350000,
			"sex": 0,
			"updateTime": 1515660267000,
			"loginCount": 71,
			"loginFailedCount": 1,
			"lastLoginIp": "0:0:0:0:0:0:0:1",
			"sexStr": "未知",
			"trueName": "1",
			"password": "sha256$6wmsmigNURLNC83QriqS478amYes5Czu$bcac23acb4da545c00b72399a893b46af230e33e92af7f4e25e21c7a16a4de75",
			"createTime": 1515653345000,
			"phone": "222",
			"id": 1,
			"email": "22_22.com",
			"statusStr_Source": "启用",
			"lastloginTime": 1521356167336,
			"status": 1
		}
	 * @param adminsJSON
	 */
	private AAdmins operAdminsSync(JSONObject adminsJSON)
	{
		/* 如果管理员第一次登陆商城系统:向数据库中插入一条记录
		 * 如果管理员大于第一次登陆商城系统:向数据库中更新一条记录 */
		/* 先查询一下如果存在,就更新,不存在就添加
		 * 按照什么查询?唯一的:ssoid:存储的用户中心管理员的id,唯一的
		 *  */
		/* 根据ssoId查询 */
		Map<String, Object> condMap = new HashMap<String, Object>() ;
		condMap.put("ssoId", adminsJSON.getIntValue("id"));
		AAdmins admins = this.usersService.findOneAdminsService(condMap);
		/* 断言 */
		boolean updateFlag = true ; 
		if(admins == null)
		{
			/* 第一次登陆 */
			admins = new AAdmins() ;
			admins.setCreateTime(new Date());
			/* 是添加的标志 */
			updateFlag = false ; 
		}
		
		admins.setSsoId(adminsJSON.getIntValue("id"));
		admins.setEmail(adminsJSON.getString("email"));
		admins.setTrueName(adminsJSON.getString("trueName"));
		admins.setStatus(AAdminsEnum.STATUS_ENABLE.getStatus());
		admins.setUpdateTime(new Date());
		admins.setLastLoginTime(new Date(Long.valueOf(adminsJSON.getLongValue("lastloginTime"))));
		/* 调用Service方法入库 */
		JSONObject resultDbJSON = new JSONObject();
		if(updateFlag)
		{
			resultDbJSON = this.usersService.updateOneAdminsService(admins);
		}else
		{
			resultDbJSON = this.usersService.saveOneAdminsService(admins);
		}
		ConstatFinalUtil.LOGGER.info("管理员登陆成功:邮箱:{},信息:{},",admins.getEmail() , resultDbJSON);
		return admins ; 
	}
}
