package com.carlinfo.parking.users.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.carlinfo.common.util.DateUtil;

/**
 * 管理员的POJO
 * 
 * @author 张培基
 */
public class AComments
{
	private int Id;
	private int userId;
	private String userName;
	private int parkingId;
	private byte star;
	private byte comType;
	private byte status;
	private String content;
	private Date createTime;
	private Date updateTime;

	/* 字符串描述 */
	private String statusStr;

	public int getId()
	{
		return Id;
	}

	public void setId(int id)
	{
		Id = id;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public int getParkingId()
	{
		return parkingId;
	}

	public void setParkingId(int parkingId)
	{
		this.parkingId = parkingId;
	}

	public byte getStar()
	{
		return star;
	}

	public void setStar(byte star)
	{
		this.star = star;
	}

	public byte getComType()
	{
		return comType;
	}

	public void setComType(byte comType)
	{
		this.comType = comType;
	}

	public byte getStatus()
	{
		return status;
	}

	public void setStatus(byte status)
	{
		this.status = status;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
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

	public String getStatusStr()
	{
		/* 状态:0:禁用;1:启用 */
		ACommentsEnum[] conmmentsEnums = ACommentsEnum.values();
		for (int i = 0; i < conmmentsEnums.length; i++)
		{
			ACommentsEnum conmmentsEnum = conmmentsEnums[i];
			/*
			 * conmmentsEnum.toString():枚举项
			 */
			if (conmmentsEnum.toString().startsWith("STATUS"))
			{
				if (this.status == conmmentsEnum.getStatus())
				{
					this.statusStr = conmmentsEnum.getInfo();
					break;
				}
			}
		}
		return statusStr;
	}

	/**
	 * 把当前的对象变成json
	 * 
	 * @return
	 */
	public JSONObject toJSON()
	{
		DateUtil dateUtil = new DateUtil();
		JSONObject resultJSON = new JSONObject();

		resultJSON.put("id", this.getId());
		resultJSON.put("userId", this.getUserId());
		resultJSON.put("userName", this.getUserName());
		resultJSON.put("parkingId", this.getParkingId());
		resultJSON.put("star", this.getStar());
		resultJSON.put("comType", this.getComType());
		resultJSON.put("status", this.getStatus());
		resultJSON.put("statusStr", this.getStatusStr());
		resultJSON.put("createTime", dateUtil.dateTimeToStr(this.getCreateTime()));
		resultJSON.put("updateTime", dateUtil.dateTimeToStr(this.getUpdateTime()));

		return resultJSON;
	}
}
