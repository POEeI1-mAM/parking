package com.carlinfo.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * http的工具类
 * @author wangshMac
 */
public class HttpUtil
{
	/**
	 * ~主流程
	 * 
	 * http请求有三个要素:和当年的ajax,当年的写信很像;
	 * 	URL:
	 * 	信的内容(参数):?键=值&键=值
	 * 	返回值:(回信)
	 * 
	 * IO流:
	 */
	public String methodGet(String requestUrl , Map<String, String> paramsMap)
	{
		StringBuffer sb = new StringBuffer() ; 
		System.out.println("==methodGet==");
		try
		{
			/*
			 * 第一个参数必须是?
			 * */
			if(requestUrl.indexOf("?") == -1)
			{
				requestUrl = requestUrl + "?" ; 
			}
			for (Iterator iterator = paramsMap.entrySet().iterator(); iterator.hasNext();)
			{
				Entry me = (Entry) iterator.next();
				String key = me.getKey() + "" ; 
				String val = me.getValue() + ""; 
				
				requestUrl = requestUrl + "&" + key + "=" + val  ;
			}
			System.out.println("==requestUrl=>" + requestUrl);
			/* 创建一个url对象;
			 * url:
			 * http://www.baidu.com/s?id=1&a=2&b=3
			 * 协议://ip(域名):端口/文件的位置?参数
			 *  */
			URL url = new URL(requestUrl) ;
			/* 打开一个链接 
			 * 返回值=右边是父类,
			 * =左边是子类,需要强转
			 * ClassCaseExecption:
			 * instanceof
			 * */
			HttpURLConnection connection = (HttpURLConnection) url.openConnection() ;
			/* 开水管 */
			InputStream is = connection.getInputStream() ; 
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			
			String line = "" ; 
			while((line = br.readLine()) != null)
			{
				//System.out.println("---->" + line);
				sb.append(line);
			}
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} 
		return sb.toString() ; 
	}
	
	public static void main(String[] args)
	{
		HttpUtil httpUtil = new HttpUtil() ; 
		/*String url = "http://www.baidu.com"; 
		 参数 
		Map<String, String> paramsMap = new HashMap<String,String>();
		paramsMap.put("a", "1");
		paramsMap.put("b", "1");
		String result = httpUtil.methodGet(url, paramsMap);
		System.out.println("====" + result);*/
		
		try
		{
			String url = "http://localhost:8080/usercenter_20180108_model2/CommonInfoServlet"; 
			/* 参数 */
			String json = "{'ver':'1', 'method':'verifyToken','pubKey':'aa','sign':'','data':{'token':'1111'}}"; 
			Map<String, String> paramsMap = new HashMap<String,String>();
			paramsMap.put("json", URLEncoder.encode(json, "UTF-8"));
			String result = httpUtil.methodGet(url, paramsMap);
			System.out.println("====" + result);
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	}
}
