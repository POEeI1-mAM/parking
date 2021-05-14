package com.carlinfo.common.dao;

import java.util.List;
import java.util.Map;

/**
 * 抽取一个BaseDao 存储的是所有Dao重复的代码
 * 
 * @author 张培基
 *
 * @param <T>
 */
public interface IBaseDao<T>
{
	/**
	 * 保存一条记录
	 * 
	 * @param region
	 *            用户的对象
	 * @return 此sql语句执行对数据库影响的条数 期望把主键放到对象的id中
	 */
	int saveOne(T t);

	/**
	 * 更新一条记录
	 * 
	 * @param region
	 * @return
	 */
	int updateOne(T t);

	/**
	 * 删除一条记录 搜索的条件和列名不一定一样; ~删除最近一个月的记录; delete * from a_region where pubtime >=
	 * stDate and pubtime < edDate ; 条件stDate和edDate不一定是表的列名
	 * 
	 * @param condMap
	 * @return
	 */
	int deleteOne(Map<String, Object> condMap);

	/**
	 * 查询单条记录 ~按照id查询(id不是重复的) ~按照邮箱查询(邮箱也不是重复的)
	 * 
	 * @return
	 */
	T findOne(Map<String, Object> condMap);

	/**
	 * 查询多条记录
	 * 
	 * dao的方法如果传两个参数,映射文件中的parameterType如何填写? Mybatis的缺点:不支持;
	 * 
	 * 直接传一个参数,类型是Map多好啊
	 * 
	 * @return
	 */
	List<T> findCondList(Map<String, Object> condMap);

}
