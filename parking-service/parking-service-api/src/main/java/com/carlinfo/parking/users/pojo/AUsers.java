package com.carlinfo.parking.users.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.util.DateUtil;


/**
 * 用户的POJO
 * 
 * @author 张培基
 */
public class AUsers 
{
	private int id;
	private int ssoId;
	private String email;

	private byte status;
	private Date createTime;
	private Date updateTime;
	private Date lastLoginTime;

	/* 字符串描述 */
	private String statusStr;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getSsoId()
	{
		return ssoId;
	}

	public void setSsoId(int ssoId)
	{
		this.ssoId = ssoId;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	

	public byte getStatus()
	{
		return status;
	}

	public void setStatus(byte status)
	{
		this.status = status;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public Date getUpdateTime()
	{
		return updateTime;
	}

	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}

	public Date getLastLoginTime()
	{
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime)
	{
		this.lastLoginTime = lastLoginTime;
	}

	public String getStatusStr()
	{
		/*状态:0:禁用;1:启用*/
		AUsersEnum[] usersEnums = AUsersEnum.values() ; 
		for (int i = 0; i < usersEnums.length; i++)
		{
			AUsersEnum usersEnum = usersEnums[i];
			/*
			 * usersEnum.toString():枚举项
			 * */
			if(usersEnum.toString().startsWith("STATUS"))
			{
				if(this.status == usersEnum.getStatus())
				{
					this.statusStr = usersEnum.getInfo() ; 
					break ; 
				}
			}
		}
		return statusStr;
	}
	
	/**
	 * 把当前的对象变成json
	 * @return
	 */
	public JSONObject toJSON()
	{
		DateUtil dateUtil = new DateUtil() ; 
		JSONObject resultJSON = new JSONObject();
		
		resultJSON.put("id", this.getId());
		resultJSON.put("ssoId", this.getSsoId());
		resultJSON.put("email", this.getEmail());
		
		resultJSON.put("status", this.getStatus());
		resultJSON.put("statusStr", this.getStatusStr());
		resultJSON.put("createTime", dateUtil.dateTimeToStr(this.getCreateTime()));
		resultJSON.put("updateTime", dateUtil.dateTimeToStr(this.getUpdateTime()));
		resultJSON.put("lastLoginTime", dateUtil.dateTimeToStr(this.getLastLoginTime()));
		return resultJSON ; 
	}
}
