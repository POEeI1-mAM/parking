package com.carlinfo.common.service;

import javax.annotation.Resource;

import com.carlinfo.common.util.FileUtil;

/**
 * 所有Service的公共方法代码
 * @author 张培基
 *
 */
public class BaseServiceImpl
{
	@Resource
	protected FileUtil fileUtil;

}
