package com.carlinfo.parking.users.service;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.util.PageInfoUtil;
import com.carlinfo.parking.users.pojo.AParkings;

public interface IParkingsService
{

	JSONObject saveOneParkingsService(AParkings parkings);
	
	
	JSONObject updateOneParkingsService(AParkings parkings);
	
	
	JSONObject deleteOneParkingsService(Map<String, Object> condMap);
	
	
	AParkings findOneParkingsService(Map<String, Object> condMap);
	
	List<AParkings> findCondListParkingsService(PageInfoUtil pageInfoUtil,Map<String, Object> condMap);

}
