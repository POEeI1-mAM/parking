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
public class AParkings
{

	private int id;
	private int createId;
	private int regionId;
	private String name;
	private String local;
	private byte status;
	private byte status1;
	private double hourPrice;
	private double dayPrice;
	private String image;
	private String content;
	private int sumCarport;
	private int useCarport;
	private int leftCarport;
	private Date createTime;
	private Date updateTime;
	
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

	public int getCreateId()
	{
		return createId;
	}

	public void setCreateId(int createId)
	{
		this.createId = createId;
	}

	public int getRegionId()
	{
		return regionId;
	}

	public void setRegionId(int regionId)
	{
		this.regionId = regionId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getLocal()
	{
		return local;
	}

	public void setLocal(String local)
	{
		this.local = local;
	}

	public byte getStatus()
	{
		return status;
	}

	public void setStatus(byte status)
	{
		this.status = status;
	}

	public byte getStatus1()
	{
		return status1;
	}

	public void setStatus1(byte status1)
	{
		this.status1 = status1;
	}

	public double getHourPrice()
	{
		return hourPrice;
	}

	public void setHourPrice(double hourPrice)
	{
		this.hourPrice = hourPrice;
	}

	public double getDayPrice()
	{
		return dayPrice;
	}

	public void setDayPrice(double dayPrice)
	{
		this.dayPrice = dayPrice;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getSumCarport()
	{
		return sumCarport;
	}

	public void setSumCarport(int sumCarport)
	{
		this.sumCarport = sumCarport;
	}

	public int getUseCarport()
	{
		return useCarport;
	}

	public void setUseCarport(int useCarport)
	{
		this.useCarport = useCarport;
	}

	public int getLeftCarport()
	{
		return leftCarport;
	}

	public void setLeftCarport(int leftCarport)
	{
		this.leftCarport = leftCarport;
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
		AParkingsEnum[] parkingsEnums = AParkingsEnum.values();
		for (int i = 0; i < parkingsEnums.length; i++)
		{
			AParkingsEnum parkingsEnum = parkingsEnums[i];
			/*
			 * adminsEnum.toString():枚举项
			 */
			if (parkingsEnum.toString().startsWith("STATUS"))
			{
				if (this.status == parkingsEnum.getStatus())
				{
					this.statusStr = parkingsEnum.getInfo();
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
		resultJSON.put("createId", this.getCreateId());
		resultJSON.put("regionId", this.getRegionId());
		resultJSON.put("name", this.getName());
		resultJSON.put("local", this.getLocal());
		
		resultJSON.put("status", this.getStatus());
		resultJSON.put("status1", this.getStatus1());
		resultJSON.put("hourPrice", this.getHourPrice());
		resultJSON.put("dayPrice", this.getDayPrice());
		resultJSON.put("image", this.getImage());
		resultJSON.put("content", this.getContent());
		resultJSON.put("sumCarPort", this.getSumCarport());
		resultJSON.put("leftCarport", this.getLeftCarport());
		resultJSON.put("statusStr", this.getStatusStr());
		resultJSON.put("createTime", dateUtil.dateTimeToStr(this.getCreateTime()));
		resultJSON.put("updateTime", dateUtil.dateTimeToStr(this.getUpdateTime()));
		
		return resultJSON;
	}
}
