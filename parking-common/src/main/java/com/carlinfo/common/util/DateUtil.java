package com.carlinfo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 日期的工具类
 * @author wangshMac
 *
 */
@Component
public class DateUtil
{
	/**
	 * 将字符串转换为日期
	 * 按照指定的格式
	 * @param str:有格式的字符串	默认的格式为:"yyyy-MM-dd"
	 * @return 根据默认的格式,将字符串转换为日期
	 */
	public Date strToDate(String str)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(ConstatFinalUtil.DATE_FORMAT);
			return sdf.parse(str) ;
		} catch (ParseException e)
		{
			e.printStackTrace();
		} 
		return null ; 
	}
	
	/**
	 * 将字符串转换为日期
	 * 按照指定的格式
	 * @param str:有格式的字符串	默认的格式为:"yyyy-MM-dd HH:mm:ss"
	 * @return 根据默认的格式,将字符串转换为日期+时间
	 */
	public Date strToDateTime(String str)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(ConstatFinalUtil.DATE_TIME_FORMAT);
			return sdf.parse(str) ;
		} catch (ParseException e)
		{
			e.printStackTrace();
		} 
		return null ; 
	}
	
	/**
	 * 将字符串转换为日期
	 * 按照指定的格式
	 * @param str:有格式的字符串
	 * @return 根据默认的格式,将字符串转换为日期
	 */
	public Date strToDate(String str,String format)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(str) ;
		} catch (ParseException e)
		{
			e.printStackTrace();
		} 
		return null ; 
	}
	
	/**
	 * 将字符串转换为日期
	 * 按照指定的格式
	 * @param str:有格式的字符串	默认的格式为:"yyyy-MM-dd"
	 * @return 根据默认的格式,将字符串转换为日期
	 */
	public String dateToStr(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(ConstatFinalUtil.DATE_FORMAT);
		return sdf.format(date); 
	}
	
	/**
	 * 将字符串转换为日期
	 * 按照指定的格式
	 * @param str:有格式的字符串	默认的格式为:"yyyy-MM-dd HH:mm:ss"
	 * @return 根据默认的格式,将字符串转换为日期+时间
	 */
	public String dateTimeToStr(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(ConstatFinalUtil.DATE_TIME_FORMAT);
		return sdf.format(date);
	}
	
	/**
	 * 将字符串转换为日期
	 * 按照指定的格式
	 * @param str:有格式的字符串
	 * @return 根据默认的格式,将字符串转换为日期
	 */
	public String dateToStr(Date date,String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
}
