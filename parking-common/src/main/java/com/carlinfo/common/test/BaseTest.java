package com.carlinfo.common.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试类的超类(父类)
测试配置文件是否配置正确,每配置完一项,都要运行此代码,如果不报错,说明代码配置木有问题
 * @author 张培基
 */
public class BaseTest
{
	//日志对象
	protected Logger logger=LogManager.getLogger();
	/* Spring的IOC容器 */
	protected ApplicationContext ac ;

	/**
	 * 执行@test之前先执行此方法
	 */
	@Before
	public void init()
	{
		ac = new ClassPathXmlApplicationContext("classpath*:spring/applicationContext-*.xml");
		this.logger.info("==初始化==");
	}
	
	@Test
	public void test()
	{
		this.logger.info("==test==");
	}
	
	/**
	 * 执行@test之后执行此方法
	 */
	@After
	public void after()
	{
		this.logger.info("==after==");
		/*
		 * instanceof:啥意思?=左边是不是=右边的一个对象
		 * */
		if(this.ac instanceof ClassPathXmlApplicationContext)
		{
			/* 万一强转失败呢? */
			ClassPathXmlApplicationContext cpxac = (ClassPathXmlApplicationContext) this.ac;
			cpxac.close();
		}
	}
}
