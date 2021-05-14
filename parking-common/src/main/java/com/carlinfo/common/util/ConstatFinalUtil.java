package com.carlinfo.common.util;

import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * 静态常量工具类
 *
 */
public class ConstatFinalUtil
{
	/* 所有的公共的日志工具类 */
	public static Logger LOGGER = LogManager.getLogger() ;

	/**
	 * 编码集
	 */
	public static final String CHARSET = "UTF-8" ;
	/**
	 * 常量字符串
	 */
	public static String ALL_STR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 
	
	/* 日期格式 */
	public static String DATE_FORMAT = "yyyy-MM-dd";
	/* 日期时间格式 */
	public static String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/* 配置文件中的对象 */
	public static JSONObject CONFIG_JSON = new JSONObject() ; 
	/* 字符串描述的对象 */
	public static JSONObject INFO_JSON = new JSONObject() ; 
	/* 配置文件中系统模块的全局配置 */
	public static JSONObject SYS_CONFIG_JSON = new JSONObject() ; 
	
	/**
	 * 初始化的时候就要读取文件的内容
	 * 只读一次
	 */
	static 
	{
		try
		{
			FileUtil fileUtil = new FileUtil() ; 
			/* 读取配置文件中的内容
			 * D:\班级\20171108\20180315_shop_搭建框架+数据库结构\代码\shop\shop-common\shop-common-util\src\main\resources\config.json
			 * 相对路径:相对于项目的Classpath
			 * ConstatFinalUtil.class:就是一个Class对象,Classpath不能够读取jar中的配置文件
			 * getClassLoader:类的加载器,,Classpath可以读取jar中的配置文件
			 * 
			 *  */
			String result = fileUtil.readFile(ConstatFinalUtil.class.getClassLoader().getResourceAsStream("config.json"));
			/* 将字符串变成JSON对象 */
			CONFIG_JSON = (JSONObject) JSON.parse(result);
			INFO_JSON = CONFIG_JSON.getJSONObject("info");
			SYS_CONFIG_JSON = CONFIG_JSON.getJSONObject("sysConfig");
		} catch (Exception e)
		{
			ConstatFinalUtil.LOGGER.error("解析配置文件出异常了;",e);
		}
	}
}
