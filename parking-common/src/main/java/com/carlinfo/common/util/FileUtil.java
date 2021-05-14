package com.carlinfo.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

/**
 * 文件工具类
 * @author wangshMac
 *
 */
@Component
public class FileUtil
{
	/**
	 * 读取输入流中的内容
	 * @param is
	 * @return	返回值为字符串
	 */
	public String readFile(InputStream is)
	{
		StringBuffer sb = new StringBuffer() ; 
		/* 异常是:选中合适的代码;alt + shift + z */
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(is, ConstatFinalUtil.CHARSET));
			String line = ""; 
			while((line = br.readLine()) != null)
			{
				sb.append(line);
			}
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return sb.toString() ; 
	}
	/**
	 * 拷贝文件,参数是文件对象,不再是管子 
	 * 
	 * @param souFile
	 * @param tarFile
	 * @return
	 */
	public boolean copy(File souFile , File tarFile)
	{
		try
		{
			FileInputStream fis = new FileInputStream(souFile);
			FileOutputStream fos = new FileOutputStream(tarFile);
			return this.copy(fis, fos) ;
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		return false ; 
	}
	
	/**
	 * 拷贝文件
	 * @return
	 */
	public boolean copy(InputStream is , OutputStream os)
	{
		/* 拷贝的时候,带上粗管子 */
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		/* 准备容器
		 * 1024 * 1024 * 2 === 2m
		 *  */
		byte[] b = new byte[2 * 1024 * 1024];
		int len = 0 ;
		try
		{
			while((len = bis.read(b)) != -1)
			{
				bos.write(b, 0, len);
			}
			/* 拷贝完成,返回true */
			return true ; 
		} catch (IOException e)
		{
			e.printStackTrace();
		}finally
		{
			try
			{
				if(bis != null)
				{
					bis.close();
					bis = null; 
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
			try
			{
				if(bos != null)
				{
					bos.close();
					bos = null ;
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return false ; 
	}
	
	public static void main(String[] args)
	{
		System.out.println("=======");
		FileUtil fileUtil = new FileUtil() ; 
		File souFile = new File("d:/test/az.jpg");
		File tarFile = new File("d:/test/az_bak.jpg");
		fileUtil.copy(souFile, tarFile);
	}
}
